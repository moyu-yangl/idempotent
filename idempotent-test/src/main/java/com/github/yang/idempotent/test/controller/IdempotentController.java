package com.github.yang.idempotent.test.controller;

import com.github.yang.idempotent.api.annotation.Idempotent;
import com.github.yang.idempotent.api.enums.IdempotentType;
import com.github.yang.idempotent.test.TestApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdempotentController {

    @GetMapping("/idempotent/test/h")
    @Idempotent(type = IdempotentType.HTTP_REQUEST)
    public String idempotentTest() {
//        String[] name = TestApplication.getName();
        System.out.println("幂等测试~~~~");
        return "ok";
    }

    @GetMapping("/idempotent/test/m")
    @Idempotent(type = IdempotentType.MESSAGE_QUEUE)
    public String idempotentTest2() {
//        String[] name = TestApplication.getName();
        System.out.println("幂等测试~~~~");
        return "ok";
    }

    @GetMapping("/idempotent/test/o")
    @Idempotent(type = IdempotentType.ORDINARY_METHOD)
    public String idempotentTest3() {
        System.out.println("方法 幂等测试~~~~");
        return "ok";
    }
}
