package com.hsbc.test.citybackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

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
                .expectBody(Long.class).isEqualTo(1L);

    }

    @Test
    void getCityCountByStartingLetterZ() {
        webClient.get().uri("/cities/count?letter=Z")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Long.class).isEqualTo(3L);

    }

    @Test
    void getCityCountByStartingLetterInvalid() {
        webClient.get().uri("/cities/count?letter=2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Long.class).isEqualTo(0L);

    }

}
