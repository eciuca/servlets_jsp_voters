package com.sda.grupa5.servlet.votare;

import com.sda.grupa5.servlet.votare.service.CountingService;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class CountingListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        CountingService.getInstance().incrementAndGet();
    }
}
