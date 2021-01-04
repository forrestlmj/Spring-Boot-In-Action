package com.yck.springbootselflearning.controller;

import com.yck.springbootselflearning.dao.Employee;
import com.yck.springbootselflearning.config.PersonConfig;
import com.yck.springbootselflearning.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:55
 */
@Api(tags = {"员工模块"})
@RestController
public class EmployeeController {
    @Autowired
    private PersonConfig personConfig;

    @Resource
    private EmployeeService employeeService;
    @ApiOperation(value = "根据员工id获得员工",notes = "这个接口的一些说明")
    @GetMapping("/employ/{id}")
    public Employee getEmpById(@PathVariable @ApiParam(value = "员工id", defaultValue = "1") Integer id){
        System.out.println(personConfig.toString());
        return employeeService.getEmpById(id);
    }

    @ApiOperation(value = "增加员工",notes = "这个接口的一些说明")
    @PostMapping("/employ")
    public Employee addEmp(@RequestBody Employee employee){
        return employeeService.saveEmp(employee);
    }
    @ApiOperation(value = "修改员工",notes = "这个接口的一些说明")
    @PutMapping("/employ")
    public Employee updateEmp(@RequestBody Employee employee){
        return employeeService.saveEmp(employee);
    }
    @ApiOperation(value = "修改员工",notes = "这个接口的一些说明")
    @DeleteMapping("/employ/{id}")
    public void deleteEmp(@PathVariable @ApiParam(value = "员工id", defaultValue = "1") Integer id){
        employeeService.deleteEmpById(id);
    }
}
