package com.github.yang.idempotent.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication {
    static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(TestApplication.class);
//        String[] name = getName();
//        System.out.println();
    }

    public static String[] getName() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        return names;
    }
}
