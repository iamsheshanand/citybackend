package com.hsbc.test.citybackend;

import com.hsbc.test.citybackend.dto.CityCountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CitybackendApplicationTests {

    @Autowired
    WebTestClient webClient;

    @Test
    void getCityCountByStartingLetterY() {
        webClient.get().uri("/cities/count?letter=Y")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CityCountResponse.class).isEqualTo(new CityCountResponse(1L, List.of("Yafran")));

    }

    @Test
    void getCityCountByStartingLetterZ() {
        webClient.get().uri("/cities/count?letter=Z")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CityCountResponse.class).isEqualTo(new CityCountResponse(3L, List.of("Zuwarah", "Zawiya", "Zlitan")));

    }

    @Test
    void getCityCountByStartingLetterInvalid() {
        webClient.get().uri("/cities/count?letter=2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CityCountResponse.class).isEqualTo(new CityCountResponse(0L, List.of()));

    }

}
