package com.design.designpatterns.weather;

import com.design.designpatterns.weather.subject.WeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WeatherService {
    private final WeatherData weatherData;

    public void updateWeatherData(WeatherDetail weatherDetail) {
        weatherData.setMeasurements(
                weatherDetail.getTemperature(),
                weatherDetail.getHumidity(),
                weatherDetail.getPressure());
    }
}
