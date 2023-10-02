package com.github.yang.idempotent.core.handler.impl;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.exception.IdempotentException;
import com.github.yang.idempotent.core.domain.IdempotentWrapper;
import com.github.yang.idempotent.core.domain.TimeMap;
import com.github.yang.idempotent.core.handler.AbstractIdempotentHandler;
import com.github.yang.idempotent.core.handler.OrdinaryMethodIdempotentHandler;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.yang.idempotent.core.context.KeyContextHolder.KEY_CONTEXT;

public class OrdinaryMethodIdempotentHandlerImpl extends AbstractIdempotentHandler implements OrdinaryMethodIdempotentHandler {
    private final TimeMap timeMap = TimeMap.getInstance();

    @Override
    protected IdempotentWrapper buildWrapper(ProceedingJoinPoint joinPoint, Idempotent idempotent) {
        return IdempotentWrapper.builder()
                .setIdempotent(idempotent)
                .setPoint(joinPoint)
                .setKey(calcArgsMD5(joinPoint))
                .build();
    }

    private String calcArgsMD5(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String collect = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(":"));
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String key = "path:" + signature.getClass().getName() + "method:" + signature.getMethod().getName() + "param" + collect;
        return DigestUtils.md5Hex(key);
    }

    @Override
    public void handler(IdempotentWrapper wrapper) {
        String key = wrapper.getKey();
        if (timeMap.get(key)) {
            throw new IdempotentException(wrapper.getIdempotent().message());
        }
        KEY_CONTEXT.set(key);
        timeMap.put(key, wrapper.getIdempotent().time() + System.currentTimeMillis());
    }

    @Override
    public void exceptionProcessing() {
        super.exceptionProcessing();
    }

    @Override
    public void postProcessing() {
//        timeMap.remove(KEY_CONTEXT.get());
    }
}
