package com.github.yang.idempotent.core.handler;

public interface IdempotentHandler {
    void handler();

    void execute();

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
