package com.sda.grupa5.servlet.votare.listeners;

import com.sda.grupa5.servlet.votare.service.CountingService;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestCountingListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        CountingService.getInstance().incrementeazaSiReturneaza();
    }
}
