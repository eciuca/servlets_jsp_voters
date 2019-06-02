package com.sda.grupa5.servlet.votare.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "FirstLoggingFilter")
public class FirstLoggingFilter extends HttpFilter {

    private static final Logger LOGGER = Logger.getLogger(FirstLoggingFilter.class.getName());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("==========================BEGINNING OF THE FILTER CHAIN==========================");
        chain.doFilter(req, res);
        LOGGER.info("=============================END OF THE FILTER CHAIN=============================");
    }
}
