package com.example.demo.security;


import com.example.demo.security.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapper {
    UserInfo selectUserInfoRoleByUsername(String username);
}
