package com.yck.springbootselflearning.service.impl;

import com.yck.springbootselflearning.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void test1(){
        System.out.println(employeeService.getEmpById(1));
    }
}