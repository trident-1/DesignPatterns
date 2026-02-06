package com.design.designpatterns.ducksim.duck;

import com.design.designpatterns.ducksim.fly.FlyWithWings;
import com.design.designpatterns.ducksim.quack.Quack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MallardDuck extends Duck{
    public MallardDuck() {
        log.info("A Mallard duck just spawned");
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        log.info("Duh... I look like Mallard Duck");
    }
}
