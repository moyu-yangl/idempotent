package com.github.yang.idempotent.api.enums;

public enum IdempotentTime {
    /**
     * 一次请求不可访问
     */
    ONCE,
    /**
     * 时间段内不可访问
     */
    TIME_PERIOD,
}
