package com.example.demo.mybatisPlus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMybatisPlusServiceImpl extends ServiceImpl<EmpMapper, EmpEntity> implements  IMybatisPlusService {


    @Override
    public List<EmpEntity> test() {
        return this.list();
    }
}
