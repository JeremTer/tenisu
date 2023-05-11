package com.abbeal.unit.infra.mapper;

import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;
import com.abbeal.infra.controller.mapper.PlayerMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@DisplayName("Player Mapper To Player Response Test")
public class PlayerMapperTest {

    private PlayerMapper sut;

    private static List<Game> createGames(Player player1, Player player2) {
        final var game1 = new Game(player1, player2,
                LocalDateTime.of(2022, 2, 2, 2, 2, 2));

        final var game2 = new Game(player2, player1,
                LocalDateTime.of(2022, 2, 2, 5, 2, 2));

        final var game3 = new Game(player1, player2,
                LocalDateTime.of(2022, 2, 2, 10, 2, 2));

        return Arrays.asList(game1, game2, game3);
    }

    private static List<Game> createGamesForDateControl(Player player1, Player player2) {
        final var game1 = new Game(player1, player2,
                LocalDateTime.of(2024, 2, 2, 2, 2, 2));

        final var game2 = new Game(player2, player1,
                LocalDateTime.of(2022, 2, 2, 5, 2, 2));

        final var game3 = new Game(player1, player2,
                LocalDateTime.of(2023, 2, 2, 10, 2, 2));

        return Arrays.asList(game1, game2, game3);
    }

    @BeforeEach
    void setUp() {
        sut = new PlayerMapper();
    }

    @Test
    @DisplayName("Should convert Integer array to int array")
    void should_convert_integer_array_to_int_array() {
        final var playerId1 = new PlayerId(1L);
        final var player1 = new Player(playerId1);

        final var playerId2 = new PlayerId(2L);
        final var player2 = new Player(playerId2);

        final List<Game> games = createGames(player1, player2);

        final var maxGameLength = 2;
        int[] expected = {1, 0};

        Assertions.assertThat(sut.mapToLastGameStates(games, playerId1, maxGameLength)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should take only the X last game by date")
    void should_take_X_last_game() {
        final var playerId1 = new PlayerId(1L);
        final var player1 = new Player(playerId1);

        final var playerId2 = new PlayerId(2L);
        final var player2 = new Player(playerId2);

        final List<Game> games = createGamesForDateControl(player1, player2);

        final var maxGameLength = 2;
        Assertions.assertThat(sut.takeOnlyLastGames(games, maxGameLength))
                .isEqualTo(Arrays.asList(games.get(0), games.get(2)));
    }

    @Test
    @DisplayName("Should map player games to a game states array")
    void should_map_games_to_games_states() {
        final var playerId1 = new PlayerId(1L);
        final var player1 = new Player(playerId1);

        final var playerId2 = new PlayerId(2L);
        final var player2 = new Player(playerId2);

        final List<Game> games = createGames(player1, player2);

        Assertions.assertThat(sut.mapToGameState(games, playerId1)).isEqualTo(Arrays.asList(1, 0, 1));
    }


}
