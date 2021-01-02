package com.yck.springbootselflearning.service;

import com.yck.springbootselflearning.dao.Employee;

public interface EmployeeService {
    Employee getEmpById(Integer id);
}
