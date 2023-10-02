package com.github.yang.idempotent.core.factory;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.enums.IdempotentScope;
import com.github.yang.idempotent.api.enums.IdempotentTime;
import com.github.yang.idempotent.api.enums.IdempotentType;
import com.github.yang.idempotent.api.exception.IdempotentException;
import com.github.yang.idempotent.core.context.ApplicationContextHolder;
import com.github.yang.idempotent.core.handler.HttpRequestIdempotentHandler;
import com.github.yang.idempotent.core.handler.IdempotentHandler;
import com.github.yang.idempotent.core.handler.MessageQueueIdempotentHandler;
import com.github.yang.idempotent.core.handler.OrdinaryMethodIdempotentHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class IdempotentHandlerFactory {
    @Autowired
    private ApplicationContextHolder applicationContextHolder;

    public static IdempotentHandler getInstance(Idempotent idempotent) {
        IdempotentType type = idempotent.type();
        IdempotentHandler res = null;
        switch (type) {
            case HTTP_REQUEST:
                res = ApplicationContextHolder.getBean(HttpRequestIdempotentHandler.class);
                break;
            case MESSAGE_QUEUE:
                res = ApplicationContextHolder.getBean(MessageQueueIdempotentHandler.class);
                break;
            case ORDINARY_METHOD:
                res = ApplicationContextHolder.getBean(OrdinaryMethodIdempotentHandler.class);
                break;
            default:
                throw new IdempotentException("没有找到类");
        }
        return res;
    }
}
