package com.github.yang.idempotent.core.handler.impl;

import com.github.yang.idempotent.core.handler.AbstractIdempotentHandler;
import com.github.yang.idempotent.core.handler.MessageQueueIdempotentHandler;
import com.github.yang.idempotent.core.wrapper.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public class MessageQueueIdempotentHandlerImpl extends AbstractIdempotentHandler implements MessageQueueIdempotentHandler {
    @Override
    protected IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        System.out.println("message build");
        return null;
    }

    @Override
    public void handler(IdempotentWrapper wrapper) {
        System.out.println("message handler");
    }
}
