package com.ipisis.fluxAndMonoPlayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception ocurred")))
                .concatWith(Flux.just("After Error"))
                .log();

        stringFlux
                .subscribe(System.out::println,
                        e -> System.err.println("Exception is " + e),
                        () -> System.out.println("Completed"));
    }

    @Test
    public void fluxTestElementsWithoutError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .log();

        StepVerifier.create(stringFlux)
        .expectNext("Spring")
        .expectNext("Spring Boot")
        .expectNext("Reactive Spring")
        .verifyComplete();
    }

    @Test
    public void fluxTestElementsWithError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Ocurred")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                //.expectError(RuntimeException.class)
                .expectErrorMessage("Exception Ocurred")
                .verify();
    }

    @Test
    public void fluxTestElementsCountWithError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Ocurred")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                //.expectError(RuntimeException.class)
                .expectErrorMessage("Exception Ocurred")
                .verify();
    }

    @Test
    public void fluxTestElementsWithErrorSimplified(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Ocurred")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring", "Spring Boot", "Reactive Spring")
                .expectErrorMessage("Exception Ocurred")
                .verify();
    }

    @Test
    public void monoTest(){
        Mono<String> stringMono = Mono.just("Spring")
                .log();

        StepVerifier.create(stringMono)
                .expectNext("Spring")
                .verifyComplete();
    }
}