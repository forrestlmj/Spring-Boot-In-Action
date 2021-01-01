package com.yck.springbootselflearning.service;

import com.yck.springbootselflearning.bean.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    Employee getEmpById(Integer id);
}
