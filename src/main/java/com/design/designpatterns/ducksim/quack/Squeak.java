package com.design.designpatterns.ducksim.quack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Squeak implements QuackBehaviour {
    public void quack() {
      log.info("I can only Squeak");
    }
}
