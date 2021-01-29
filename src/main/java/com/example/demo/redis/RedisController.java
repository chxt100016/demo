package com.example.demo.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("/get")
    public String get (String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/set")
    public void set(String key, String value) {
        for (int i = 0; i < 100; i++) {
            this.redisTemplate.opsForValue().set(key + i, value + i);
        }
    }
}
