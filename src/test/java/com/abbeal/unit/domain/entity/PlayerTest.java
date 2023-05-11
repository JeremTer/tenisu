package com.abbeal.unit.domain.entity;

import com.abbeal.unit.factory.PlayerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Player Entity Tests")
public class PlayerTest {

    @Test
    @DisplayName("Should calculate BMI")
    public void should_calculate_BMI() {
        final var player = PlayerFactory.getPlayer1();
        player.calculateBodyMassIndex();
        Assertions.assertThat(player.getBodyMassIndex()).isEqualTo(21.62);
    }


}
