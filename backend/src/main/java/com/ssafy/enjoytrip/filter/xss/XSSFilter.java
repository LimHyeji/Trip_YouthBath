package com.ssafy.enjoytrip.filter.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import javax.servlet.Filter;
import java.io.IOException;

public class XSSFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("called");
        HttpServletRequestWrapper requestWrapper = new XSSFilterWrapper((HttpServletRequest)request);
        chain.doFilter(requestWrapper,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig=null;
    }
}