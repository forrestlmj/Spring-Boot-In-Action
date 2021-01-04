package com.yck.springbootselflearning.dto;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/4 上午11:20
 */


public class DeptSummary {
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Double getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Double peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Double getSalaryCount() {
        return salaryCount;
    }

    public void setSalaryCount(Double salaryCount) {
        salaryCount = salaryCount;
    }

    @Override
    public String toString() {
        return "DeptSummary{" +
                "departmentName='" + departmentName + '\'' +
                ", peopleCount=" + peopleCount +
                ", SalaryCount=" + salaryCount +
                '}';
    }

    private String departmentName;
    private Double peopleCount;
    private Double salaryCount;
}
