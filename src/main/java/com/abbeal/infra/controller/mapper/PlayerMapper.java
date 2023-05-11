package com.abbeal.infra.controller.mapper;

import com.abbeal.domain.entity.Country;
import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;
import com.abbeal.infra.controller.response.CountryResponse;
import com.abbeal.infra.controller.response.DataResponse;
import com.abbeal.infra.controller.response.PlayerResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public List<PlayerResponse> mapToPlayersResponse(List<Player> players) {
        return players.stream()
                .map(this::mapToOnePlayerResponse)
                .collect(Collectors.toList());
    }

    public PlayerResponse mapToOnePlayerResponse(Player player) {
        return new PlayerResponse(
                player.getId().id(),
                player.getFirstname(),
                player.getLastname(),
                player.getShortname(),
                player.getSex(),
                mapToCountryResponse(player.getCountry()),
                player.getPicture(),
                mapToDataResponse(player)
        );
    }

    private DataResponse mapToDataResponse(Player player) {
        return new DataResponse(player.getRank(),
                player.getPoints(),
                player.getWeight(),
                player.getHeightInCentimeter(),
                player.getAge(),
                player.getLastGameStates()
        );
    }


    public int[] mapToLastGameStates(List<Game> games, PlayerId playerId, int lastGameNumber) {
        final var lastGames = takeOnlyLastGames(games, lastGameNumber);
        final var gameStates = mapToGameState(lastGames, playerId);
        return gameStates.stream().mapToInt(state -> state).toArray();
    }

    public List<Integer> mapToGameState(List<Game> games, PlayerId playerId) {
        return games.stream()
                .map(game -> game.winner().getId().equals(playerId) ? 1 : 0)
                .collect(Collectors.toList());
    }

    private CountryResponse mapToCountryResponse(Country country) {
        return new CountryResponse(country.getPicture(), country.getId().code());
    }

    public List<Game> takeOnlyLastGames(List<Game> games, int maxGameLength) {
        return games.stream()
                .sorted(Comparator.comparing(Game::date).reversed())
                .limit(maxGameLength)
                .collect(Collectors.toList());
    }
}
