package com.design.designpatterns.ducksim.quack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Quack implements QuackBehaviour {
    public void quack() {
        log.info("Quack");
    }
}
