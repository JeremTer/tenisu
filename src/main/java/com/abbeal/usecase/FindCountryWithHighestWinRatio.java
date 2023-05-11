package com.abbeal.usecase;

import com.abbeal.domain.entity.Country;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class FindCountryWithHighestWinRatio {

    private final PlayerRepository playerRepository;

    public FindCountryWithHighestWinRatio(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Country execute() {
        final var players = playerRepository.getAllPlayers();
        final var countries = players.stream().map(Player::getCountry).collect(Collectors.toSet());

        countries.forEach(country -> {
            final var countryPlayers = findPlayersOfThisCountry(players, country);
            countryPlayers.forEach(player -> calculateWinsAndDefeats(country, player));
            country.calculateWinRatio();
        });

        return findCountryWithHighestWinRatio(countries);
    }

    private Country findCountryWithHighestWinRatio(Set<Country> countries) {
        return countries.stream()
                .max(Comparator.comparing(Country::getWinRatio))
                .orElseThrow();
    }

    private void calculateWinsAndDefeats(Country country, Player player) {
        final var lastGameStates = player.getLastGameStates();
        final var wins = lastGameStates.stream().mapToInt(Integer::intValue).sum();
        country.incrementWinsNumber(wins);
        country.incrementDefeatsNumber(lastGameStates.size() - wins);
    }

    private List<Player> findPlayersOfThisCountry(List<Player> players, Country country) {
        return players.stream().filter(player -> player.getCountry().equals(country)).toList();
    }
}
