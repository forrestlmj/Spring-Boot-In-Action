package com.yck.springbootselflearning.controller;

import com.yck.springbootselflearning.bean.Department;
import com.yck.springbootselflearning.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午6:45
 */
@Api(tags = {"部门模块"})
@RestController
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @ApiOperation(value = "根据id获取部门",notes = "这个接口的备注说明")
    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable @ApiParam(value = "部门id", defaultValue = "1")  Integer id){
        return departmentService.getDeptById(id);
    }
}
