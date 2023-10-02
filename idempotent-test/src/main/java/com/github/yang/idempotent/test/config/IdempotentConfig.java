package com.github.yang.idempotent.test.config;


import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.handler.MessageQueueIdempotentHandler;
import com.github.yang.idempotent.core.handler.impl.HttpRequestIdempotentHandlerImpl;
import com.github.yang.idempotent.core.handler.impl.MessageQueueIdempotentHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdempotentConfig {

    @Bean
    public HttpRequestIdempotentHandler httpRequestIdempotentHandler() {
        return new HttpRequestIdempotentHandlerImpl();
    }

    @Bean
    public MessageQueueIdempotentHandler messageQueueIdempotentHandler() {
        return new MessageQueueIdempotentHandlerImpl();
    }
}


