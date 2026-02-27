package com.design.designpatterns.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Profile("ObserverPattern")
@Slf4j
@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> weather(@RequestBody WeatherDetail weatherDetail) {
      log.info("Received weather data");
      weatherService.updateWeatherData(weatherDetail);
      return Mono.just(ResponseEntity.ok("""
               {
                "message" : "Rodger that."
               }
              """));
    }
}
