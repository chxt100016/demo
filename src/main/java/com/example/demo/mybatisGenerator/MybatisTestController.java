package com.example.demo.mybatisGenerator;


import com.example.demo.mybatisGenerator.mapper.CourseMapper;
import com.example.demo.mybatisGenerator.model.CourseEntity;
import com.example.demo.mybatisGenerator.model.CourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatisGenerator")
public class MybatisTestController {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private Environment env;

    @GetMapping("/test")
    public void test(){
        CourseExample example = new CourseExample();
        example.createCriteria().andCidEqualTo("01");
        List<CourseEntity> courses =  courseMapper.list();
        System.out.println(courses);
        System.out.println("env=" + env.getProperty("mybatis.configuration.map-underscore-to-camel-case"));

    }
}
