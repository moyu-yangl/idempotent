package com.github.yang.idempotent.api.exception;

public class IdempotentException extends RuntimeException {
    public IdempotentException(String msg) {
        super(msg);
    }
}
