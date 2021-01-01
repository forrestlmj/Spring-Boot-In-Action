package com.yck.springbootselflearning.service.impl;

import com.yck.springbootselflearning.bean.Employee;
import com.yck.springbootselflearning.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:50
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee getEmpById(Integer id) {
        return new Employee(1,"yangck","yangck@163.com",1);
    }
}
