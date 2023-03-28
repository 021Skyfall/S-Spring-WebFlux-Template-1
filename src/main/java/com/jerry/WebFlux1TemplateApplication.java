package com.jerry;

import com.jerry.MVC.Dto.CoffeeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;

// MVC 기반 애플리케이션
//@Slf4j
//@SpringBootApplication
//public class WebFlux1TemplateApplication {
//	private final RestTemplate restTemplate;
//
//	public WebFlux1TemplateApplication(RestTemplateBuilder restTemplateBuilder) {
//		this.restTemplate = restTemplateBuilder.build();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(WebFlux1TemplateApplication.class, args);
//	}
//
//	@Bean
//	public CommandLineRunner run() {
//		return (String... args) -> {
//			log.info("# 요청 시작 시간: {}", LocalDateTime.now());
//
//			for (int i = 0; i <= 5; i++) {
//				CoffeeResponseDto response = this.getCoffee();
//				log.info("{}: coffee name: {}", LocalTime.now(), response.getKorName());
//			}
//		};
//	}
//	private CoffeeResponseDto getCoffee() {
//		String uri = "http://localhost:8080/coffees/1";
//		ResponseEntity<CoffeeResponseDto> response = restTemplate.getForEntity(uri, CoffeeResponseDto.class);
//
//		return response.getBody();
//	}
//}
@Slf4j
@SpringBootApplication
public class WebFlux1TemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebFlux1TemplateApplication.class, args);
	}
}