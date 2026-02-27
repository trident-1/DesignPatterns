package com.design.designpatterns.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class WeatherDetail {
    private double temperature;
    private double humidity;
    private double pressure;
}
