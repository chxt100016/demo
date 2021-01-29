package com.example.demo.getBean;

import org.springframework.stereotype.Service;

@Service
public class C implements A{
    @Override
    public String a() {
        return "C";
    }
}
