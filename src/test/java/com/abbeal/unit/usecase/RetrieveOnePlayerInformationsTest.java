package com.abbeal.unit.usecase;

import com.abbeal.domain.entity.Game;
import com.abbeal.domain.entity.Player;
import com.abbeal.unit.domain.repository.FakePlayerRepository;
import com.abbeal.unit.factory.PlayerFactory;
import com.abbeal.usecase.RetrieveOnePlayerInformations;
import com.abbeal.usecase.exceptions.UnknownPlayerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Usecase Retrieve One Player Informations")
public class RetrieveOnePlayerInformationsTest {

    private RetrieveOnePlayerInformations sut;

    @BeforeEach
    void setUp() {
        final var fakePlayerRepository = new FakePlayerRepository();
        sut = new RetrieveOnePlayerInformations(fakePlayerRepository);
    }

    @Test
    @DisplayName("Should throw player not found exception if player does not exist")
    void should_throw_not_found_exception() {
        Exception exception = assertThrows(UnknownPlayerException.class, () -> sut.execute(34L));

        String expectedMessage = "This player does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Should retrieve all player informations")
    void should_retrieve_player_informations() {
        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();

        final var game1 = new Game(player2, player1, LocalDateTime.of(2022, 2, 2, 12, 12));
        final var game2 = new Game(player2, player1, LocalDateTime.of(2022, 2, 13, 12, 12));
        player1.setGames(Arrays.asList(game1, game2));
        player2.setGames(Arrays.asList(game1, game2));

        Assertions.assertThat(sut.execute(1L))
                .usingRecursiveComparison()
                .isEqualTo(player1);

    }


}
