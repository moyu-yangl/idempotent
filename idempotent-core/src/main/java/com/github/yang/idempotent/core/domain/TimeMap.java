package com.github.yang.idempotent.core.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static com.github.yang.idempotent.core.context.KeyContextHolder.KEY_CONTEXT;

public class TimeMap {
    static {
        random = new Random();
    }

    private static volatile TimeMap timeMap;
    private static Random random;
    private final Map<String, Long> timer;

    public static TimeMap getInstance() {
        if (timeMap == null) {
            synchronized (TimeMap.class) {
                if (timeMap == null) {
                    timeMap = new TimeMap();
                }
            }
        }
        return timeMap;
    }

    private TimeMap() {
        timer = new ConcurrentHashMap<>();
    }

    public void put(String key, Long time) {
        timer.put(key, time);
    }

    public boolean get(String key) {
        return checkTime(key);
    }

    public void remove(String key) {
        timer.remove(key);
    }

    public void checkTime() {
        Set<String> keySet = timer.keySet();
        double size = keySet.size();
        IntStream ints = random.ints((long) Math.ceil(size / 4), 0, (int) (size - 1));
    }

    private boolean checkTime(String key) {
        Long time = timer.get(key);
        if (time == null)
            return false;
        if (time <= System.currentTimeMillis()) {
            timer.remove(key);
        }
        return time > System.currentTimeMillis();
    }

}
