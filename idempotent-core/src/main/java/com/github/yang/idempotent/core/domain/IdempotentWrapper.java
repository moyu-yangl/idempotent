package com.github.yang.idempotent.core.domain;

import com.github.yang.idempotent.api.annotation.Idempotent;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Objects;

public class IdempotentWrapper {
    private Idempotent idempotent;
    private String key;
    private ProceedingJoinPoint point;

    public static IdempotentWrapperBuilder builder() {
        return new IdempotentWrapperBuilder();
    }

    public IdempotentWrapper(IdempotentWrapperBuilder builder) {
        this.idempotent = builder.idempotent;
        this.key = builder.key;
        this.point = builder.point;
    }

    public Idempotent getIdempotent() {
        return idempotent;
    }

    public void setIdempotent(Idempotent idempotent) {
        this.idempotent = idempotent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ProceedingJoinPoint getPoint() {
        return point;
    }

    public void setPoint(ProceedingJoinPoint point) {
        this.point = point;
    }

    public static class IdempotentWrapperBuilder {
        Idempotent idempotent;
        String key;
        ProceedingJoinPoint point;

        public IdempotentWrapperBuilder setIdempotent(Idempotent idempotent) {
            this.idempotent = idempotent;
            return this;
        }

        public IdempotentWrapperBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public IdempotentWrapperBuilder setPoint(ProceedingJoinPoint point) {
            this.point = point;
            return this;
        }

        public IdempotentWrapper build() {
            return new IdempotentWrapper(this);
        }
    }
}


