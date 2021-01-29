//package com.example.demo.generalMapper;
//
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/generalMapper")
//public class GeneralMapperController {
//
//    @Autowired
//    private DeptMapper deptMapper;
//
//
//    @GetMapping("/test")
//    public void test() {
//        Example example = new Example(Dept.class);
//        example.createCriteria().andEqualTo("deptNo", "30").andEqualTo("dName", "SALES");
//        List<Dept> list = this.deptMapper.selectByExample(example);
//        System.out.println(list);
//    }
//
//}
