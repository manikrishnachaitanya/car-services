package com.example.web.client;

import com.example.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PricingServiceClient {

    private final WebClient webClient;

    public Mono<Integer> getPriceEstimate(Car car) {
        return webClient.post()
                .uri("http://pricing-service-service:8093/api/price/estimate")
                .bodyValue(car)
                .retrieve()
                .bodyToMono(Integer.class);
    }
}
