package com.abbeal.usecase;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveAllPlayersByRank {

    private final PlayerRepository playerRepository;

    public RetrieveAllPlayersByRank(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> execute() {
        final var players = playerRepository.getAllPlayers();
        return sortPlayersByRanking(players);
    }

    public List<Player> sortPlayersByRanking(List<Player> players) {
        return players.stream()
                .sorted(Comparator.comparing(Player::getRank))
                .collect(Collectors.toList());
    }
}
