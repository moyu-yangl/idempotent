package com.github.yang.idempotent.core.factory;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.enums.IdempotentScope;
import com.github.yang.idempotent.api.enums.IdempotentTime;
import com.github.yang.idempotent.api.enums.IdempotentType;
import com.github.yang.idempotent.core.handler.IdempotentHandler;

public class IdempotentHandlerFactory {
    public static IdempotentHandler getInstance(Idempotent idempotent) {
        IdempotentTime range = idempotent.range();
        IdempotentScope[] scope = idempotent.scope();
        IdempotentType type = idempotent.type();
        return null;
    }
}
