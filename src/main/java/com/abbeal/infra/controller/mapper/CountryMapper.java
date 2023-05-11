package com.abbeal.infra.controller.mapper;

import com.abbeal.domain.entity.Country;
import com.abbeal.infra.controller.response.CountryDetailsResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDetailsResponse mapToCountryDetailsResponse(Country country) {
        return new CountryDetailsResponse(country.getPicture(), country.getId().code(), country.getWinsNumber(), country.getDefeatsNumber(), country.getWinRatio());
    }

}
