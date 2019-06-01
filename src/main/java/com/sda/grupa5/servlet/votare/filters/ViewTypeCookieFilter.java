package com.sda.grupa5.servlet.votare.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = "/*")
public class ViewTypeCookieFilter extends HttpFilter {

    public static final String VIEW_TYPE_PARAM = "viewType";
    public static final String VIEW_TYPE_PARAM_DEFAULT_VALUE = "scriptlet";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Optional<Cookie> viewTypeCookie = Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals(VIEW_TYPE_PARAM))
                .findFirst();

        String paramValue = req.getParameter(VIEW_TYPE_PARAM);

        if (viewTypeCookie.isPresent()) {
            if (paramValue != null && !paramValue.equals(viewTypeCookie.get().getValue())) {
                Cookie cookie = viewTypeCookie.get();
                cookie.setValue(paramValue);
                res.addCookie(cookie);
            }
        } else {
            String cookieValue = paramValue != null ? paramValue : VIEW_TYPE_PARAM_DEFAULT_VALUE;
            res.addCookie(new Cookie(VIEW_TYPE_PARAM, cookieValue));
        }

        chain.doFilter(req, res);
    }
}
