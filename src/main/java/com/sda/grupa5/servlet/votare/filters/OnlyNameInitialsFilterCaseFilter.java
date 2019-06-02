package com.sda.grupa5.servlet.votare.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebFilter(filterName = "OnlyNameInitialsFilterCaseFilter")
public class OnlyNameInitialsFilterCaseFilter extends HttpFilter {

    private static final Logger LOGGER = Logger.getLogger(OnlyNameInitialsFilterCaseFilter.class.getName());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("start");
        String fullname = req.getParameter("fullnameParam");
        if (fullname != null) {
            req.setAttribute("fullnameParam", Arrays.stream(fullname.split(" ")).map(s -> s.substring(0,1)+ ".").collect(Collectors.joining(" ")));
        }

        chain.doFilter(req, res);

        String fullnameResp = (String) req.getAttribute("fullname");
        req.setAttribute("fullname", "Mr. " + fullnameResp);
        LOGGER.info("end");
    }
}
