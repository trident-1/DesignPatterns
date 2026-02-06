package com.design.designpatterns.ducksim;

import com.design.designpatterns.ducksim.duck.Duck;
import com.design.designpatterns.ducksim.duck.MallardDuck;
import com.design.designpatterns.ducksim.duck.RedheadDuck;
import com.design.designpatterns.ducksim.duck.RubberDuck;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Example of Strategy Pattern - Lets the algorithms vary independently of clients using it
 * Encapsulate what varies.
 * Favour composition over inheritance.
 * Program to interfaces, not implementations.
 */
@Component
@Profile("StrategyPattern")
public class DuckJesus {

    @PostConstruct
    public void letThereBeDucks() {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.swim();
        mallardDuck.fly();

        Duck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.quack();
        redheadDuck.fly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.fly();
    }
}
