package com.design.designpatterns.logging;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Operators;

@Configuration
public class ReactorMdcBridgeConfig {

    @PostConstruct
    public void registerHook() {
        Hooks.onEachOperator("mdc-bridge",
                Operators.lift((_, subscriber) -> new MdcSubscriber<>(subscriber))
        );
    }
}
