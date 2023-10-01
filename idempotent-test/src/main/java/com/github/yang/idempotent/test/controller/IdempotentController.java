package com.github.yang.idempotent.test.controller;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.enums.IdempotentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdempotentController {

    @GetMapping("/idempotent/test")
    @Idempotent(type = IdempotentType.HTTP_REQUEST)
    public String idempotentTest() {
        System.out.println("幂等测试~~~~");
        return "ok";
    }
}
