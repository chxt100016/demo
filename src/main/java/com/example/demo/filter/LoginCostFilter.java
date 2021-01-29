package com.example.demo.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCostFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request.getRequestURI());
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        filterChain.doFilter(new XssHttpServletRequestWrapper(request), response);
        long endTime = System.currentTimeMillis();
        System.out.println(request.getRequestURI() + " - cost time:" + (endTime - startTime));
    }
}
