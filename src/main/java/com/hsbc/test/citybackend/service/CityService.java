package com.hsbc.test.citybackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.stream.StreamSupport;

@Service
public class CityService {

    private final WebClient webClient;

    public CityService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl("https://samples.openweathermap.org").build();
    }
    public Long findCitiesStartingWith(String letter) {
        if (letter == null || letter.trim().isEmpty()) {
            return 0L;
        }

        String firstLetter = letter.trim().toLowerCase().substring(0, 1);
        Mono<JsonNode> retrievedResponse = webClient.get()
                .uri("/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22")
                .retrieve()
                .bodyToMono(JsonNode.class);

        try {
            JsonNode retrievedResponseNode = retrievedResponse.block();

            if (retrievedResponseNode == null || !retrievedResponseNode.has("list")) {
                return 0L;
            }
            return StreamSupport.stream(
                            retrievedResponseNode.get("list").spliterator(), false)
                    .filter(node -> node.has("name") &&
                                    node.get("name").asText().toLowerCase().startsWith(firstLetter))
                    .count();

        }catch (Exception e){
            return 0L;
        }
    }
}
