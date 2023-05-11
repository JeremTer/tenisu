package com.abbeal.unit.domain.repository;

import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import com.abbeal.unit.factory.PlayerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class FakePlayerRepository implements PlayerRepository {
    @Override
    public List<Player> getAllPlayers() {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();
        final var game1 = new Game(player2, player1, LocalDateTime.of(2022, 2, 2, 12, 12));
        final var game2 = new Game(player2, player1, LocalDateTime.of(2022, 2, 13, 12, 12));
        player1.setGames(Arrays.asList(game1, game2));
        player2.setGames(Arrays.asList(game1, game2));
        return Arrays.asList(player1, player2);
    }
}
