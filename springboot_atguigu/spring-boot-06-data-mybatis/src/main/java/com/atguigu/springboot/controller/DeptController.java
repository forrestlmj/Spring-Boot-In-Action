package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/31 下午2:30
 */

@RestController
public class DeptController {
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return new Employee(1,"yangchengkai",1,"yangchengkai@yunzhangfang.com");
    }
}
