package com.example.demo.getBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/getBean/test")
    public void test(){
        Map<String, A> beansOfType = this.context.getBeansOfType(A.class);
        for (Map.Entry<String, A> stringAEntry : beansOfType.entrySet()) {
            System.out.println(stringAEntry.getValue().a());
        }
    }
}
