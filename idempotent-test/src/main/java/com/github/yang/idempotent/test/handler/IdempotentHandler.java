package com.github.yang.idempotent.test.handler;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.handler.AbstractIdempotentHandler;
import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.domain.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public class IdempotentHandler extends AbstractIdempotentHandler implements HttpRequestIdempotentHandler {
    @Override
    protected IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint, Idempotent idempotent) {
        return null;
    }

    @Override
    public void handler(IdempotentWrapper wrapper) {

    }
}
