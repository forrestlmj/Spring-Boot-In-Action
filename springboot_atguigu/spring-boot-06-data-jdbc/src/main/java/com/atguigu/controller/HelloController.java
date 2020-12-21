package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/21 上午9:36
 */

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public List<Map<String,Object>> map(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list;
    }
}
