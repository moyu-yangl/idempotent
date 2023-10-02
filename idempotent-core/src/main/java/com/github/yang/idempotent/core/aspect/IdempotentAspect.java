package com.github.yang.idempotent.core.aspect;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.exception.IdempotentException;
import com.github.yang.idempotent.core.factory.IdempotentHandlerFactory;
import com.github.yang.idempotent.core.handler.IdempotentHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
public class IdempotentAspect {

    @Around("@annotation(idempotent)")
    public Object idempotentHandler(ProceedingJoinPoint point, Idempotent idempotent) {
        // 获取要校验幂等方法的信息
        // 构建幂等逻辑
        IdempotentHandler instance = IdempotentHandlerFactory.getInstance(idempotent);
        // 执行幂等操作
        Object res = null;
        try {
            instance.execute(point, idempotent);
            res = point.proceed();
            instance.postProcessing();
        } catch (Throwable e) {
            instance.exceptionProcessing();
            if (e instanceof IdempotentException)
                throw new IdempotentException(idempotent.message());
        }
        //返回幂等判断后的消息
        return res;

    }

}
