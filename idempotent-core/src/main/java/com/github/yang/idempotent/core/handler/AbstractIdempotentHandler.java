package com.github.yang.idempotent.core.handler;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.domain.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractIdempotentHandler implements IdempotentHandler {
    protected abstract IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint, Idempotent idempotent);

    @Override
    public void execute(ProceedingJoinPoint point, Idempotent idempotent) {
        IdempotentWrapper wrapper = buildWrapper(point, idempotent);
        handler(wrapper);
    }
}
