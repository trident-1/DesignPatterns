package com.design.designpatterns.ducksim.duck;

import com.design.designpatterns.ducksim.fly.FlyBehaviour;
import com.design.designpatterns.ducksim.quack.QuackBehaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void quack() {
        quackBehaviour.quack();
    }

    public void fly() {
        flyBehaviour.fly();
    }

    public void swim() {
        log.info("I'm swimming. All ducks swim, don't they?");
    }

    public void display() {
        log.info("Look at me. I'm a duck.");
    }
}
