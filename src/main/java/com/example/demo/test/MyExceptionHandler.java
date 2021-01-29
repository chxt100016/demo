package com.example.demo.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exHandler(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
