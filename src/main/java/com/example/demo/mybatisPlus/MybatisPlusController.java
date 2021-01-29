package com.example.demo.mybatisPlus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plus")
public class MybatisPlusController  {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private IMybatisPlusService iMybatisPlusService;

    @RequestMapping("/test")
    public List<EmpEntity> test(int num, int size) {

        Page<EmpEntity> page = new Page<>(num, size);
        Page<EmpEntity> select = this.empMapper.selectPage(
                page,
               null
        );

        return this.iMybatisPlusService.list();

    }

    @RequestMapping("/d")
    public List<DeptEntity> d(Integer num, Integer size) {

//        Page<EmpEntity> page = new Page<>(num, size);
        IPage<DeptEntity> select = this.empMapper.listDeptno(new Page<>(num, size));
        return select.getRecords();

    }

}
