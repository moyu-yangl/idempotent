package com.github.yang.idempotent.api.annotation;

import com.github.yang.idempotent.api.enums.IdempotentScope;
import com.github.yang.idempotent.api.enums.IdempotentTime;
import com.github.yang.idempotent.api.enums.IdempotentType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {
    /**
     * 过期时间
     * @return
     */
    long time() default 5000;

    /**
     * 时间粒度
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * 应用幂等的方法类型
     * @return
     */
    IdempotentType type();

    /**
     * 幂等的生命周期，可以是一次方法持续的时间内，可以是指定时间内。
     * @return
     */
    IdempotentTime range() default IdempotentTime.TIME_PERIOD;

    /**
     * 进行幂等验证的范围，可以用IP、参数等进行验证
     * @return
     */
    IdempotentScope[]scope() default {IdempotentScope.PARAMETER};

    /**
     * 触发幂等返回的异常信息
     * @return
     */
    String message() default "触发幂等，请稍后重试";
}
