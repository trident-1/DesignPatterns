package com.design.designpatterns.ducksim.fly;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyNoFly implements FlyBehaviour{
    public void fly() {
        log.info("Are you CrAzYyYY? I can't Fly.");
    }
}
