package com.sda.grupa5.servlet.votare.service;

import java.util.concurrent.atomic.AtomicInteger;

public class CountingService {

    private static CountingService INSTANCE;

    private final AtomicInteger count;

    private CountingService() {
        count = new AtomicInteger(0);
    }

    public static CountingService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CountingService();
        }

        return INSTANCE;
    }

    public int incrementAndGet() {
        return count.incrementAndGet();
    }

    public int getCounterValue() {
        return count.intValue();
    }
}
