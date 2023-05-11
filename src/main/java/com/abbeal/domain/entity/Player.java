package com.abbeal.domain.entity;


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
    private int weight;
    private int height;
    private int age;
    private List<Game> games;

    private List<Integer> lastGameStates;

    public Player(PlayerId id) {
        this.id = id;
    }

    public Player(PlayerId id, String firstname, String lastname, String shortname, String sex, Country country, String picture, int rank, int points, int weight, int height, int age, List<Integer> lastGameStates) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortname = shortname;
        this.sex = sex;
        this.country = country;
        this.picture = picture;
        this.rank = rank;
        this.points = points;
        this.weight = weight;
        this.height = height;
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
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


}
