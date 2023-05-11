package com.abbeal.infra.controller.response;

public record PlayerResponse(
        Long id,
        String firstname,
        String lastname,
        String shortname,
        String sex,
        CountryResponse country,
        String picture,
        DataResponse data
) {
}
