package com.jerry.MVC.controller;

import com.jerry.MVC.Dto.CoffeeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/coffees")
public class SpringMvcMainCoffeeController {
    private final RestTemplate restTemplate;

    public SpringMvcMainCoffeeController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    String uri = "http://localhost:7070/coffees/1";

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        log.info("# call Spring MVC Main Controller: {}", LocalDateTime.now());

        ResponseEntity<CoffeeResponseDto> response = restTemplate.getForEntity(uri,CoffeeResponseDto.class);
        return ResponseEntity.ok(response.getBody());
    }
}
