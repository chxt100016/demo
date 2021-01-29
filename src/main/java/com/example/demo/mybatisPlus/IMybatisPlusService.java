package com.example.demo.mybatisPlus;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IMybatisPlusService extends IService<EmpEntity> {

    List<EmpEntity> test();
}
