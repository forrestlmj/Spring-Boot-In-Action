package com.atguigu.controller;

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
    @GetMapping("/query")
    public List<Map<String,Object>> map(){
        Map<String,Object> m = new HashMap<>();
        m.put("1","1");
        List<Map<String,Object>> list =Arrays.asList(m);
        return list;
    }
}
