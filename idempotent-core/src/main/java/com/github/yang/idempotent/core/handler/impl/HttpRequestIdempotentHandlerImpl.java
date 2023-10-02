package com.github.yang.idempotent.core.handler.impl;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.handler.AbstractIdempotentHandler;
import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.domain.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;


public class HttpRequestIdempotentHandlerImpl extends AbstractIdempotentHandler implements HttpRequestIdempotentHandler {
    @Override
    protected IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint, Idempotent idempotent) {

        System.out.println("build wrapper");
        return null;
    }

    @Override
    public void handler(IdempotentWrapper wrapper) {
        System.out.println("http request");
    }
}
