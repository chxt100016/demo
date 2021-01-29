package com.example.demo.test;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoMapper {

    @Insert({"update user_info set content= #{content} where username = #{username}"})
    void update(@Param("username") String username, @Param("content") String content);

    @Select({"select * from EMP"})
    List<Map<String, Object>> select(String username);
}
