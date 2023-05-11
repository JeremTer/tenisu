package com.abbeal.infra.controller;

import com.abbeal.infra.controller.mapper.CountryMapper;
import com.abbeal.infra.controller.response.CountryDetailsResponse;
import com.abbeal.usecase.FindCountryWithHighestWinRatio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
public class CountryController {


    private final FindCountryWithHighestWinRatio findCountryWithHighestWinRatio;
    private final CountryMapper countryMapper;

    public CountryController(FindCountryWithHighestWinRatio findCountryWithHighestWinRatio, CountryMapper countryMapper) {
        this.findCountryWithHighestWinRatio = findCountryWithHighestWinRatio;
        this.countryMapper = countryMapper;
    }

    @GetMapping("/best-win-ratio")
    public ResponseEntity<CountryDetailsResponse> findCountryWithHighestWinRatio() {
        final var country = findCountryWithHighestWinRatio.execute();

        return ResponseEntity.ok(countryMapper.mapToCountryDetailsResponse(country));
    }

}
