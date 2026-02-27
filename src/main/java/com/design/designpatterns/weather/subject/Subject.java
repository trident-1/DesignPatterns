package com.design.designpatterns.weather.subject;

import com.design.designpatterns.weather.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
