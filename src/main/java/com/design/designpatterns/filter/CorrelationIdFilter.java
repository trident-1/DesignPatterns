package com.design.designpatterns.filter;

import io.micrometer.common.util.StringUtils;
import lombok.NonNull;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorrelationIdFilter implements WebFilter {

    public static final String HEADER = "X-Correlation-ID";
    public static final String CONTEXT_KEY = "correlationId";

    public @NonNull Mono<Void> filter(@NonNull ServerWebExchange exchange,
                                      @NonNull WebFilterChain chain) {

        String correlationId = exchange.getRequest()
                .getHeaders()
                .getFirst(HEADER);

        if (StringUtils.isBlank(correlationId)) {
            correlationId = UUID.randomUUID().toString();
        }

        exchange.getResponse().getHeaders().add(HEADER, correlationId);


        String finalCorrelationId = correlationId;
        return chain.filter(exchange)
                .contextWrite(ctx -> ctx.put(CONTEXT_KEY, finalCorrelationId));
    }
}
