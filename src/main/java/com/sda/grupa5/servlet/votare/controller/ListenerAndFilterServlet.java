package com.sda.grupa5.servlet.votare.controller;

import com.sda.grupa5.servlet.votare.service.CountingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ListenerAndFilterServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ListenerAndFilterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("start");
        String fullnameParam = (String) req.getAttribute("fullnameParam");
        req.setAttribute("fullname", fullnameParam);
        req.setAttribute("requestCount", CountingService.getInstance().getCounterValue());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/listener_and_filter.jsp")
                .forward(req, resp);
        LOGGER.info("end");
    }
}
