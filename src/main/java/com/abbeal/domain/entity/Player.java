package com.abbeal.domain.entity;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Player {

    private final PlayerId id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private Country country;
    private String picture;
    private int rank;
    private int points;
    private int weightInGram;
    private int heightInCentimeter;
    private int age;
    private List<Game> games;

    private List<Integer> lastGameStates;

    private double bodyMassIndex;

    public Player(PlayerId id) {
        this.id = id;
    }

    public Player(PlayerId id, String firstname, String lastname, String shortname, String sex, Country country, String picture, int rank, int points, int weight, int heightInCentimeter, int age, List<Integer> lastGameStates) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortname = shortname;
        this.sex = sex;
        this.country = country;
        this.picture = picture;
        this.rank = rank;
        this.points = points;
        this.weightInGram = weight;
        this.heightInCentimeter = heightInCentimeter;
        this.age = age;
        this.lastGameStates = lastGameStates;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWeight() {
        return weightInGram;
    }

    public void setWeight(int weight) {
        this.weightInGram = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public PlayerId getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public String getSex() {
        return sex;
    }

    public Country getCountry() {
        return country;
    }

    public String getPicture() {
        return picture;
    }

    public int getPoints() {
        return points;
    }

    public int getHeightInCentimeter() {
        return heightInCentimeter;
    }

    public void setHeightInCentimeter(int heightInCentimeter) {
        this.heightInCentimeter = heightInCentimeter;
    }

    public int getAge() {
        return age;
    }

    public List<Game> getGames() {
        return games;
    }

    public List<Integer> getLastGameStates() {
        return lastGameStates;
    }

    public void setLastGameStates(List<Integer> lastGameStates) {
        this.lastGameStates = lastGameStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void calculateBodyMassIndex() {
        final double heightInMeter = (double) heightInCentimeter / 100;
        final double weightInKg = (double) weightInGram / 1000;
        final var value = weightInKg / (heightInMeter * heightInMeter);
        bodyMassIndex = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getBodyMassIndex() {
        return bodyMassIndex;
    }
}
