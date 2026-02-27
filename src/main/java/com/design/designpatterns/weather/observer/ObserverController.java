package com.design.designpatterns.weather.observer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Profile("ObserverPattern")
@Slf4j
@RestController
@RequestMapping("/observers/weather")
@RequiredArgsConstructor
public class ObserverController {

    private final ObserverJesus observerJesus;

    @PutMapping(path = "/subscribe", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> subscribe(@RequestParam String observer) {
        log.info("Received subscribe request");
        observerJesus.subscribe(observer);
        return Mono.just(ResponseEntity.ok("""
               {
                "message" : "Subscribed. Get ready for the the updates."
               }
              """));
    }

    @PutMapping(path = "/unsubscribe", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> unsubscribe(@RequestParam String observer) {
        log.info("Received unsubscribe request");
        observerJesus.unsubscribe(observer);
        return Mono.just(ResponseEntity.ok("""
               {
                "message" : "Unsubscribed. Was it too expensive?"
               }
              """));
    }
}
