package com.abbeal.unit.usecase;

import com.abbeal.unit.domain.repository.FakePlayerRepositoryWithMorePlayers;
import com.abbeal.usecase.FindMedianPlayerHeight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Usecase Find Median Player Height")
public class FindMedianPlayerHeightTest {

    private FindMedianPlayerHeight sut;

    @BeforeEach
    void setUp() {
        final var fakePlayerRepository = new FakePlayerRepositoryWithMorePlayers();
        sut = new FindMedianPlayerHeight(fakePlayerRepository);
    }

    @Test
    @DisplayName("Should calculate median player height")
    void should_calculate_median_player_height() {
        Assertions.assertThat(sut.execute()).isEqualTo(180);
    }

}
