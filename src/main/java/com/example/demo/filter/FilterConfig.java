package com.example.demo.filter;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new PrintFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("LogCostFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean registLoginFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new LoginCostFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("LoginFilter");
//        registration.setOrder(-1000);
//        return registration;
//    }
}
