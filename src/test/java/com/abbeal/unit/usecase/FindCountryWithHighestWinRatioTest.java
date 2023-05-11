package com.abbeal.unit.usecase;

import com.abbeal.domain.entity.Country;
import com.abbeal.domain.entity.CountryId;
import com.abbeal.domain.entity.Player;
import com.abbeal.unit.domain.repository.FakePlayerRepositoryForFindingCountry;
import com.abbeal.unit.factory.PlayerFactory;
import com.abbeal.usecase.FindCountryWithHighestWinRatio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("Usecase Find The Country With The Highest Winning Ratio")
public class FindCountryWithHighestWinRatioTest {

    private FindCountryWithHighestWinRatio sut;

    @BeforeEach
    void setUp() {
        final var fakePlayerRepository = new FakePlayerRepositoryForFindingCountry();
        sut = new FindCountryWithHighestWinRatio(fakePlayerRepository);
    }

    @Test
    @DisplayName("Should find country with best winning ratio")
    void should_find_country_with_best_winning_ratio() {

        final Player player1 = PlayerFactory.getPlayer1();
        final Player player2 = PlayerFactory.getPlayer2();
        final Player player3 = PlayerFactory.getPlayer3();
        final Player player4 = PlayerFactory.getPlayer4();

        player1.setLastGameStates(Arrays.asList(0, 1));
        player2.setLastGameStates(List.of(1));
        player3.setLastGameStates(List.of(1));
        player4.setLastGameStates(Arrays.asList(0, 0));

        final var expectedCountry = new Country(new CountryId("USA"), "pic");

        Assertions.assertThat(sut.execute()).isEqualTo(expectedCountry);
    }

}
