package com.sda.grupa5.servlet.votare.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class OnlyInitialsFilter extends HttpFilter {

    private static final Logger LOGGER = Logger.getLogger(OnlyInitialsFilter.class.getName());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Start");
        String fullnameParam = (String) req.getAttribute("fullnameParam");
                                                                             // "Emanuel Ciuca"
        String onlyInitials = Arrays.stream(fullnameParam.split(" ")) // ["Emanuel", "Ciuca"]
                                .map(cuvant -> cuvant.substring(0,1) + ".") // ["E.","C."]
                                .collect(Collectors.joining(" ")); // "E. C."

        req.setAttribute("fullnameParam", onlyInitials);

        chain.doFilter(req, res);
        LOGGER.info("End");
    }
}
