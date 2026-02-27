package com.design.designpatterns.weather.display;

import com.design.designpatterns.weather.observer.Observer;
import com.design.designpatterns.weather.subject.WeatherData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentConditionsDisplay implements DisplayElement, Observer {
    private double temperature;
    private double humidity;
    private final WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
        log.info("Current Conditions Display Created");
    }

    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    public void display() {
      log.info("Current Conditions : Temperature is {} degrees Celsius and humidity is {}%",
              temperature, humidity);
    }
}
