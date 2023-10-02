package com.github.yang.idempotent.core.handler.impl;

import com.github.yang.idempotent.core.handler.AbstractIdempotentHandler;
import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.wrapper.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;


public class HttpRequestIdempotentHandlerImpl extends AbstractIdempotentHandler implements HttpRequestIdempotentHandler {
    @Override
    protected IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        System.out.println("build wrapper");
        return null;
    }

    @Override
    public void handler(IdempotentWrapper wrapper) {
        System.out.println("http request");
    }
}
