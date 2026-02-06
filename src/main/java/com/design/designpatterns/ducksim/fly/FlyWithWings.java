package com.design.designpatterns.ducksim.fly;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyWithWings implements FlyBehaviour{
    public void fly() {
        log.info("I'm flying with wings");
    }
}
