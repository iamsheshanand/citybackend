package com.hsbc.test.citybackend.controller;

import com.hsbc.test.citybackend.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> cityCount(@RequestParam(name = "letter", required = false) String letter) {
        return ResponseEntity.ok(cityService.findCitiesStartingWith(letter)) ;
    }
}
