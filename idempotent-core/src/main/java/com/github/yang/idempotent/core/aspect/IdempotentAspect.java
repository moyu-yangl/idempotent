package com.github.yang.idempotent.core.aspect;

import com.github.yang.idempotent.api.annotation.Idempotent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IdempotentAspect {

//    @Around("@annotation(idempotent)")
//    public Object idempotentHandler(JoinPoint point, Idempotent idempotent) {
//
//    }

}
