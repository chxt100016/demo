package com.example.demo.mybatisGenerator.mapper;

import com.example.demo.mybatisGenerator.model.Course;
import com.example.demo.mybatisGenerator.model.CourseEntity;
import com.example.demo.mybatisGenerator.model.CourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    @Select("select * from course")
    List<CourseEntity> list();
}