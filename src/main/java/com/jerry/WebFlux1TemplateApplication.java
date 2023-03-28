package com.jerry;

import com.jerry.Dto.CoffeeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

// WebFlux 기반 애플리케이션
@Slf4j
@SpringBootApplication
public class WebFlux1TemplateApplication {

	public static void main(String[] args) {
		System.setProperty("reactor.netty.ioWorkerCount", "1");
		SpringApplication.run(WebFlux1TemplateApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (String... args) -> {
			log.info("# 요청 시작 시간: {}", LocalTime.now());

			// (1)
			for (int i = 1; i <= 5; i++) {
				this.getCoffee()
						.subscribe(
								response -> {
									log.info("{}: coffee name: {}", LocalTime.now(), response.getKorName());
								}
						);
			}
		};
	}

	private Mono<CoffeeResponseDto> getCoffee() {
		String uri = "http://localhost:6060/coffees/1";

		return WebClient.create()
				.get()
				.uri(uri)
				.retrieve()
				.bodyToMono(CoffeeResponseDto.class);
	}
}