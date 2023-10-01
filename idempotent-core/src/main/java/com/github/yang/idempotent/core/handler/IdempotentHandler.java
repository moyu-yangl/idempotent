package com.github.yang.idempotent.core.handler;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.wrapper.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public interface IdempotentHandler {
    void handler(IdempotentWrapper wrapper);

    void execute(ProceedingJoinPoint point, Idempotent idempotent);

    /**
     * 异常流程处理
     */
    default void exceptionProcessing() {

    }

    /**
     * 后置处理
     */
    default void postProcessing() {

    }

}
