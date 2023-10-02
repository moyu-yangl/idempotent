package com.github.yang.idempotent.api.enums;

public enum IdempotentScope {
    /**
     * 请求参数验证
     */
    PARAMETER,
    /**
     * 携带token验证
     */
    TOKEN,
    /**
     * 请求ip验证
     */
    IP,
    /**
     * 用户id验证
     */
    USER_ID,
}
