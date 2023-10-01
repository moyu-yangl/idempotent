package com.github.yang.idempotent.test.config;

import com.github.yang.idempotent.core.aspect.IdempotentAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdempotentConfig {
    @Bean
    public IdempotentAspect idempotentAspect() {
        return new IdempotentAspect();
    }
}
