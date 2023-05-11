package com.abbeal.unit.domain.entity;

import com.abbeal.domain.entity.Country;
import com.abbeal.domain.entity.CountryId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Country Entity Tests")
public class CountryTest {

    @Test
    @DisplayName("Should calculate win ratio")
    public void should_calculate_win_ratio() {
        final var country1 = new Country(new CountryId("FR"), "p");
        country1.incrementWinsNumber(5);
        country1.incrementDefeatsNumber(15);
        country1.calculateWinRatio();

        Assertions.assertThat(country1.getWinRatio()).isEqualTo(0.25);

    }

    @Test
    @DisplayName("Should handle no win when calculating win ratio")
    public void calculate_win_ratio_should_handle_no_win() {
        final var country1 = new Country(new CountryId("FR"), "p");
        country1.incrementWinsNumber(0);
        country1.incrementDefeatsNumber(15);
        country1.calculateWinRatio();

        Assertions.assertThat(country1.getWinRatio()).isEqualTo(0);

    }

    @Test
    @DisplayName("Should handle no lose when calculating win ratio")
    public void calculate_win_ratio_should_handle_no_lose() {
        final var country1 = new Country(new CountryId("FR"), "p");
        country1.incrementWinsNumber(2);
        country1.incrementDefeatsNumber(0);
        country1.calculateWinRatio();

        Assertions.assertThat(country1.getWinRatio()).isEqualTo(1);
    }

}
