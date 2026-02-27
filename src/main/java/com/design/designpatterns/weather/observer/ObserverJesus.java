package com.design.designpatterns.weather.observer;

import com.design.designpatterns.weather.display.CurrentConditionsDisplay;
import com.design.designpatterns.weather.display.ForecastDisplay;
import com.design.designpatterns.weather.subject.WeatherData;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ObserverPattern")
@Component
@RequiredArgsConstructor
@Slf4j
public class ObserverJesus {

    private final WeatherData weatherData;

    private CurrentConditionsDisplay currentConditionsDisplay;
    private ForecastDisplay forecastDisplay;

    @PostConstruct
    public void letThereBeObservers() {
        this.currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        this.forecastDisplay = new ForecastDisplay(weatherData);
    }

    public void unsubscribe(String observer) {
        if(observer.equalsIgnoreCase("forecast")) {
            weatherData.removeObserver(forecastDisplay);
        }  else if(observer.equalsIgnoreCase("current")) {
            weatherData.removeObserver(currentConditionsDisplay);
        }
    }

    public void subscribe(String observer) {
        if(observer.equalsIgnoreCase("forecast")) {
            weatherData.registerObserver(forecastDisplay);
        } else if(observer.equalsIgnoreCase("current")) {
            weatherData.registerObserver(currentConditionsDisplay);
        }
    }
}
