package com.design.designpatterns.ducksim.duck;

import com.design.designpatterns.ducksim.fly.FlyWithWings;
import com.design.designpatterns.ducksim.quack.Quack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedheadDuck extends Duck{
    public RedheadDuck() {
        log.info("A Redhead duck just spawned");
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        log.info("What? You never seen a redhead before?");
    }
}
