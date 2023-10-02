package com.github.yang.idempotent.core.handler;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.core.domain.IdempotentWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public interface IdempotentHandler {
    /**
     * 实际幂等执行逻辑
     *
     * @param wrapper
     */
    void handler(IdempotentWrapper wrapper);

    /**
     * 执行幂等校验
     *
     * @param point
     * @param idempotent
     */
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
