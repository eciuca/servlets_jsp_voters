package com.sda.grupa5.servlet.votare.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "UpperCaseFilter")
public class FullnameUpperCase extends HttpFilter {

    private static final Logger MY_LOGGER = Logger.getLogger(FullnameUpperCase.class.getName());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        MY_LOGGER.info("Start");
        String fullnameParam = req.getParameter("fullnameParam");
        req.setAttribute("fullnameParam", fullnameParam.toUpperCase());

        chain.doFilter(req, res);
        MY_LOGGER.info("End");
    }
}
