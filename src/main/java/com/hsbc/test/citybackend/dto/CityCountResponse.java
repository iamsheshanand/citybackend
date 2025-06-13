package com.hsbc.test.citybackend.dto;

import java.util.List;

public record CityCountResponse(Long count, List<String> cities) {
}
