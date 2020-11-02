package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：11/2/20 3:30 PM
 */

@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String lastName;

    @GetMapping("sayHello")
    public String hello(){
        return "hello:"+lastName;
    }
}
