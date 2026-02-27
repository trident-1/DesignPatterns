package com.design.designpatterns.weather.subject;

import com.design.designpatterns.weather.observer.Observer;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Getter
@Component
public class WeatherData implements Subject {
    private final HashSet<Observer> observers;
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {
        observers = new HashSet<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void measurementsChanged() {
       notifyObservers();
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
