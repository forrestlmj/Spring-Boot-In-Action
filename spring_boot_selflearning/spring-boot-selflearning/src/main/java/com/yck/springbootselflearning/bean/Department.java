package com.yck.springbootselflearning.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:47
 */

@ApiModel(value = "部门")
public class Department {
    @ApiModelProperty(value = "部门id")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    @ApiModelProperty("部门名称")
    private String departmentName;
}
