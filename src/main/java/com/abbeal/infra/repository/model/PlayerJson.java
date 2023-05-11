package com.abbeal.infra.repository.model;

public class PlayerJson {
    private Long id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private CountryJson country;
    private String picture;
    private PlayerDataJson data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public CountryJson getCountry() {
        return country;
    }

    public void setCountry(CountryJson country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public PlayerDataJson getData() {
        return data;
    }

    public void setData(PlayerDataJson data) {
        this.data = data;
    }
}

