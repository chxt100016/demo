package com.example.demo.test;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(3);
        set.add(7);

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(3);
        list.add(7);
        System.out.println(set.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().distinct().sorted().collect(Collectors.toList()));


    }











}
