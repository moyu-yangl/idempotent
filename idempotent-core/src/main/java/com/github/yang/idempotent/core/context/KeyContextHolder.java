package com.github.yang.idempotent.core.context;

public class KeyContextHolder {
    public static ThreadLocal<String> KEY_CONTEXT = new ThreadLocal<>();
}
