package com.example.demo.getBean;

import org.springframework.stereotype.Service;

@Service
public class B  implements A{
    @Override
    public String a() {
        return "B";
    }
}
