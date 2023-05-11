package com.abbeal.usecase;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;


@Service
public class FindMedianPlayerHeight {
    private final PlayerRepository playerRepository;

    public FindMedianPlayerHeight(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public double execute() {
        final var players = playerRepository.getAllPlayers();
        final var playerHeights = players.stream().map(Player::getHeightInCentimeter).sorted().toList();

        if (playerHeights.size() % 2 == 0) {
            return (double) (playerHeights.get(playerHeights.size() / 2) + playerHeights.get(playerHeights.size() / 2 - 1)) / 2;
        }

        return playerHeights.get(playerHeights.size() / 2);
    }
}
