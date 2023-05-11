package com.abbeal.infra.controller.response;

public record CountryDetailsResponse(String picture, String code, int numberOfWins, int numberOfDefeats,
                                     double winRatio) {
}
