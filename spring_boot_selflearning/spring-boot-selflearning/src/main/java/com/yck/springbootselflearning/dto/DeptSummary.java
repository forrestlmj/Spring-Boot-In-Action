package com.yck.springbootselflearning.dto;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/4 上午11:20
 */


public class DeptSummary {

    @Override
    public String toString() {
        return "DeptSummary{" +
                "departmentName='" + departmentName + '\'' +
                ", peopleCount=" + peopleCount +
                ", SalaryCount=" + salaryCount +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(double peopleCount) {
        this.peopleCount = peopleCount;
    }

    public double getSalaryCount() {
        return salaryCount;
    }

    public void setSalaryCount(double salaryCount) {
        this.salaryCount = salaryCount;
    }

    private String departmentName;
    private double peopleCount;
    private double salaryCount;
}
