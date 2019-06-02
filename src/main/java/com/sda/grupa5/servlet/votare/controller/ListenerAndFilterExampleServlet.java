package com.sda.grupa5.servlet.votare.controller;

import com.sda.grupa5.servlet.votare.service.CountingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ListenerAndFilterExampleServlet extends HttpServlet {

    private static final Logger MY_LOGGER = Logger.getLogger(ListenerAndFilterExampleServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MY_LOGGER.info("Start");
        String fullnameParam = (String) req.getAttribute("fullnameParam");
        req.setAttribute("fullname", fullnameParam);

        int requestCount = CountingService.getInstance().damiValoareaCurenta();
        req.setAttribute("requestCount", requestCount);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/listener_and_filter.jsp")
                .forward(req, resp);
        MY_LOGGER.info("End");
    }
}
