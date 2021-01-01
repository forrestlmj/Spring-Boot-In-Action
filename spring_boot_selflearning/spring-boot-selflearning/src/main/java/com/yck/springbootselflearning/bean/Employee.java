package com.yck.springbootselflearning.bean;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:46
 */


public class Employee {
    private Integer id;
    private String lastName;
    private String email;

    public Employee(Integer id, String lastName, String email, Integer deptId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    private Integer deptId;
}
