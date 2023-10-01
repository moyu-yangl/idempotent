package com.github.yang.idempotent.api.enums;

public enum IdempotentType {
    /**
     * http请求
     */
    HTTP_REQUEST,
    /**
     * 普通方法
     */
    ORDINARY_METHOD,
    /**
     * 消息队列消息请求
     */
    MESSAGE_QUEUE,
}
