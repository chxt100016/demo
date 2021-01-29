package com.example.demo.test;

import lombok.Data;

@Data
public class TestParam {
    private String name;
    private String city;
    private Tags tags;

    @Data
    private static class Tags {
        private String channel;
        private String index;
    }


}
