package com.design.designpatterns.logging;

import org.jspecify.annotations.NonNull;
import org.reactivestreams.Subscription;
import org.slf4j.MDC;
import reactor.core.CoreSubscriber;
import reactor.util.context.Context;

class MdcSubscriber<T> implements CoreSubscriber<T> {

    private final CoreSubscriber<T> delegate;

    MdcSubscriber(CoreSubscriber<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    @NonNull
    public Context currentContext() {
        return delegate.currentContext();
    }

    @Override
    public void onSubscribe(Subscription s) {
        delegate.onSubscribe(s);
    }

    @Override
    public void onNext(T t) {
        withMdc(() -> delegate.onNext(t));
    }

    @Override
    public void onError(Throwable t) {
        withMdc(() -> delegate.onError(t));
    }

    @Override
    public void onComplete() {
        withMdc(delegate::onComplete);
    }

    private void withMdc(Runnable action) {
        String MDC_KEY = "correlationId";
        String correlationId = currentContext().getOrDefault(MDC_KEY, null);

        if (correlationId != null) {
            MDC.put(MDC_KEY, correlationId);
        }

        try {
            action.run();
        } finally {
            MDC.remove(MDC_KEY);
        }
    }
}
