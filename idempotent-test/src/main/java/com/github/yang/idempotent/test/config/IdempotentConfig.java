package com.github.yang.idempotent.test.config;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.aspect.IdempotentAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//@Configuration
public class IdempotentConfig {
}


@Component
class IdempotentAspectTest extends IdempotentAspect {

    @Override
    public Object idempotentHandler(ProceedingJoinPoint point, Idempotent idempotent) {
        System.out.println("重写了1~~~~");
        return super.idempotentHandler(point, idempotent);
    }
}

