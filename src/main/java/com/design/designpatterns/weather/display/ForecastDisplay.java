package com.design.designpatterns.weather.display;

import com.design.designpatterns.weather.observer.Observer;
import com.design.designpatterns.weather.subject.WeatherData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForecastDisplay  implements DisplayElement, Observer {
    private double lastPressure;
    private double currentPressure;
    private final WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
        log.info("Forecast Display Created");
    }

    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }

    public void display() {
        if(currentPressure == lastPressure) {
            log.info("Change doesn't happen every day bro");
        } else if(currentPressure > lastPressure) {
            log.info("Could be a pleasant day ahead");
        } else {
            log.info("Beware. This is the calm before a storm");
        }
    }
}
