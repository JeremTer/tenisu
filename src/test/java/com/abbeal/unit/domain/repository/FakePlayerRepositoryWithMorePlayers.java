package com.abbeal.unit.domain.repository;

import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;
import com.abbeal.domain.repository.PlayerRepository;
import com.abbeal.unit.factory.PlayerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class FakePlayerRepositoryWithMorePlayers implements PlayerRepository {
    @Override
    public List<Player> getAllPlayers() {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();
        final Player player3 = PlayerFactory.getPlayer3();
        final Player player4 = PlayerFactory.getPlayer4();

        player1.setLastGameStates(Arrays.asList(0, 1));
        player2.setLastGameStates(List.of(1));
        player3.setLastGameStates(List.of(1));
        player4.setLastGameStates(Arrays.asList(0, 0));

        return Arrays.asList(player1, player2, player3, player4);
    }

    @Override
    public Player getPlayer(PlayerId id) {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();
        final var game1 = new Game(player2, player1, LocalDateTime.of(2022, 2, 2, 12, 12));
        final var game2 = new Game(player2, player1, LocalDateTime.of(2022, 2, 13, 12, 12));
        player1.setGames(Arrays.asList(game1, game2));
        player2.setGames(Arrays.asList(game1, game2));

        if (id.id() == 1L) {
            return player1;
        } else if (id.id() == 2L) {
            return player2;
        }
        return null;
    }
}
