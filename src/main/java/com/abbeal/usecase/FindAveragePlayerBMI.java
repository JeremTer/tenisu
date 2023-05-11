package com.abbeal.usecase;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class FindAveragePlayerBMI {
    private final PlayerRepository playerRepository;

    public FindAveragePlayerBMI(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public double execute() {
        final var players = playerRepository.getAllPlayers();
        players.forEach(Player::calculateBodyMassIndex);

        final var bmiSum = players.stream().mapToDouble(Player::getBodyMassIndex).sum();
        final var averageBmi = bmiSum / players.size();
        return new BigDecimal(averageBmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
