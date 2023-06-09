package com.abbeal.unit.factory;

import com.abbeal.domain.entity.Country;
import com.abbeal.domain.entity.CountryId;
import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;

public class PlayerFactory {

    public static Player getPlayer2() { // IMC 74/(1,75*1,75) = 24,16
        final var playerId2 = new PlayerId(2L);
        final var player2 = new Player(playerId2);
        player2.setFirstname("cecile");
        player2.setLastname("lastname");
        player2.setShortname("ce");
        player2.setSex("F");


        final var usaCountryId = new CountryId("USA");
        final var usaCountry = new Country(usaCountryId);
        usaCountry.setPicture("countryPicture");

        player2.setCountry(usaCountry);
        player2.setPicture("picture");
        player2.setRank(1);
        player2.setPoints(1000000);
        player2.setWeight(74000);
        player2.setHeightInCentimeter(175);
        player2.setAge(32);
        return player2;
    }

    public static Player getPlayer1() { //IMC 74/(1,85*1,85) = 21,62
        final var playerId1 = new PlayerId(1L);
        final var player1 = new Player(playerId1);
        player1.setFirstname("roger");
        player1.setLastname("lastname");
        player1.setShortname("rog");
        player1.setSex("M");


        final var frCountryId = new CountryId("FR");
        final var frCountry = new Country(frCountryId);
        frCountry.setPicture("countryPicture");

        player1.setCountry(frCountry);
        player1.setPicture("picture");
        player1.setRank(3);
        player1.setPoints(33333);
        player1.setWeight(74000);
        player1.setHeightInCentimeter(185);
        player1.setAge(22);
        return player1;
    }

    public static Player getPlayer3() {

        final var playerId1 = new PlayerId(3L);
        final var player1 = new Player(playerId1);
        player1.setFirstname("bernard");
        player1.setLastname("lastname");
        player1.setShortname("b");
        player1.setSex("M");


        final var frCountryId = new CountryId("FR");
        final var frCountry = new Country(frCountryId);
        frCountry.setPicture("countryPicture");

        player1.setCountry(frCountry);
        player1.setPicture("picture");
        player1.setRank(9);
        player1.setPoints(33333);
        player1.setWeight(74000);
        player1.setHeightInCentimeter(185);
        player1.setAge(82);
        return player1;
    }

    public static Player getPlayer4() {

        final var playerId1 = new PlayerId(4L);
        final var player1 = new Player(playerId1);
        player1.setFirstname("benjamin");
        player1.setLastname("lastname");
        player1.setShortname("b");
        player1.setSex("Not provided");


        final var itCountryId = new CountryId("ITA");
        final var itCountry = new Country(itCountryId);
        itCountry.setPicture("countryPicture");

        player1.setCountry(itCountry);
        player1.setPicture("picture");
        player1.setRank(30);
        player1.setPoints(444);
        player1.setWeight(74000);
        player1.setHeightInCentimeter(175);
        player1.setAge(11);
        return player1;
    }

}
