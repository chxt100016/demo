package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class JwtTest {

    public static void main(String[] args) {
        //构建
        JwtBuilder builder= Jwts.builder()
                .setId("888")   //设置唯一编号
                .setSubject("white")//设置主题  可以是JSON数据
                .setIssuedAt(new Date())//设置签发日期
                .claim("name", "chxt")
                .signWith(SignatureAlgorithm.HS256,"qqqqqq");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        String token =builder.compact();
        System.out.println( token );

        //解析

        Claims claims = Jwts.parser().setSigningKey( "qqqqqq" ).parseClaimsJws( token ).getBody();
        System.out.println(claims);
    }

}
