package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/31 下午2:30
 */

@RestController
public class DeptController {
    Logger logger = LoggerFactory.getLogger(DeptController.class.getName());
    @Resource
    private DepartmentMapper departmentMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return new Employee(1,"yangchengkai",1,"yangchengkai@yunzhangfang.com");
    }

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department addDept(Department department){
        departmentMapper.insertDept(department);
        logger.info(department.toString());
        return department;
    }


}
