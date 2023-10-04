package com.github.yang.idempotent.core.config;

import com.github.yang.idempotent.core.aspect.IdempotentAspect;
import com.github.yang.idempotent.core.context.ApplicationContextHolder;
import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.handler.MessageQueueIdempotentHandler;
import com.github.yang.idempotent.core.handler.OrdinaryMethodIdempotentHandler;
import com.github.yang.idempotent.core.handler.impl.HttpRequestIdempotentHandlerImpl;
import com.github.yang.idempotent.core.handler.impl.MessageQueueIdempotentHandlerImpl;
import com.github.yang.idempotent.core.handler.impl.OrdinaryMethodIdempotentHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdempotentConfig {
    @Bean
    public IdempotentAspect idempotentAspect() {
        return new IdempotentAspect();
    }

    @Bean
    public HttpRequestIdempotentHandler httpRequestIdempotentHandler() {
        return new HttpRequestIdempotentHandlerImpl();
    }

    @Bean
    public MessageQueueIdempotentHandler messageQueueIdempotentHandler() {
        return new MessageQueueIdempotentHandlerImpl();
    }

    @Bean
    public OrdinaryMethodIdempotentHandler ordinaryMethodIdempotentHandler() {
        return new OrdinaryMethodIdempotentHandlerImpl();
    }

    @Bean
    public ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }
}
