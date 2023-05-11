package com.abbeal.unit.usecase;

import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.unit.domain.repository.FakePlayerRepository;
import com.abbeal.unit.factory.PlayerFactory;
import com.abbeal.usecase.RetrieveAllPlayersByRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

@DisplayName("Usecase Retrieve Players By Best Rank First")
public class RetrieveAllPlayersByRankTest {

    private RetrieveAllPlayersByRank sut;

    @BeforeEach
    void setUp() {
        final var fakePlayerRepository = new FakePlayerRepository();
        sut = new RetrieveAllPlayersByRank(fakePlayerRepository);
    }

    @Test
    @DisplayName("Should sort players by best ranking first")
    void should_sort_players_by_ranking() {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();

        Assertions.assertThat(sut.sortPlayersByRanking(Arrays.asList(player1, player2)))
                .usingRecursiveComparison()
                .isEqualTo(Arrays.asList(player2, player1));
    }

    @Test
    @DisplayName("Should return all player infos by best ranking")
    void should_return_players_infos() {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();

        final var game1 = new Game(player2, player1, LocalDateTime.of(2022, 2, 2, 12, 12));
        final var game2 = new Game(player2, player1, LocalDateTime.of(2022, 2, 13, 12, 12));
        player1.setGames(Arrays.asList(game1, game2));
        player2.setGames(Arrays.asList(game1, game2));

        Assertions.assertThat(sut.execute())
                .usingRecursiveComparison()
                .isEqualTo(Arrays.asList(player2, player1));
    }


}
