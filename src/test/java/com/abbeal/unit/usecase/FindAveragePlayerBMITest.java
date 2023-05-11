package com.abbeal.unit.usecase;

import com.abbeal.unit.domain.repository.FakePlayerRepositoryWithMorePlayers;
import com.abbeal.usecase.FindAveragePlayerBMI;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Usecase Find Average Player BMI")
public class FindAveragePlayerBMITest {

    private FindAveragePlayerBMI sut;

    @BeforeEach
    void setUp() {
        final var fakePlayerRepository = new FakePlayerRepositoryWithMorePlayers();
        sut = new FindAveragePlayerBMI(fakePlayerRepository);
    }

    @Test
    @DisplayName("Should calculate average BMI of all players")
    void should_calculate_average_BMI() {
        Assertions.assertThat(sut.execute()).isEqualTo(22.89);
    }

}
