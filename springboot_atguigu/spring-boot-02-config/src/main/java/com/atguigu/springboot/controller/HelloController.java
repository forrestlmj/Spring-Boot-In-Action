package com.atguigu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：11/2/20 3:30 PM
 */

@RestController
public class HelloController {
    @GetMapping("sayHello")
    public String hello(){
        return "hello";
    }
}
