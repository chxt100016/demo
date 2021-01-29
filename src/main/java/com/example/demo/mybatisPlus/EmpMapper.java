package com.example.demo.mybatisPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmpMapper extends BaseMapper<EmpEntity> {
    IPage<DeptEntity> listDeptno(Page<DeptEntity> page);
}
