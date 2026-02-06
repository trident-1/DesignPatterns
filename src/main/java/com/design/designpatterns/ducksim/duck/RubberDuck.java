package com.design.designpatterns.ducksim.duck;

import com.design.designpatterns.ducksim.fly.FlyNoFly;
import com.design.designpatterns.ducksim.quack.Squeak;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RubberDuck extends Duck{
    public RubberDuck() {
        log.info("A Rubber duck just spawned");
        flyBehaviour = new FlyNoFly();
        quackBehaviour = new Squeak();
    }

    @Override
    public void display() {
        log.info("Ah... I'm so yellow today.");
    }
}
