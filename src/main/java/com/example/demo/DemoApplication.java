package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication()
//@MapperScan("com.example.demo.generalMapper")
//@MapperScan("com.example.demo.**.mapper")
@RestController
public class DemoApplication  {

    @Autowired
    private Environment env;

    @RequestMapping("/myenv")
    public String myenv(String name) {
        return this.env.getProperty(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(DemoApplication.class);
//    }

}
