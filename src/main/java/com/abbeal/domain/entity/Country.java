package com.abbeal.domain.entity;

import java.util.Objects;

public class Country {

    private final CountryId id;

    private String picture;

    public Country(CountryId id) {
        this.id = id;
    }

    public Country(CountryId id, String picture) {
        this.id = id;
        this.picture = picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public CountryId getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }
}
