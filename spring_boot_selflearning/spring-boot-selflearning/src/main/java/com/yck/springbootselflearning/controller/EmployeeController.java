package com.yck.springbootselflearning.controller;

import com.yck.springbootselflearning.bean.Employee;
import com.yck.springbootselflearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:55
 */

@RestController
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @GetMapping("/employ/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        return employeeService.getEmpById(id);
    }
}
