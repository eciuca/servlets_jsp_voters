package com.sda.grupa5.servlet.votare.service;

import java.util.concurrent.atomic.AtomicInteger;

public class CountingService {

    private static CountingService INSTANCE;
    private final AtomicInteger COUNTER = new AtomicInteger(0);

    private CountingService() {

    }

    public static CountingService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CountingService();
        }

        return INSTANCE;
    }

    public int incrementeazaSiReturneaza() {
        return COUNTER.incrementAndGet();
    }

    public int damiValoareaCurenta() {
        return COUNTER.intValue();
    }
}
