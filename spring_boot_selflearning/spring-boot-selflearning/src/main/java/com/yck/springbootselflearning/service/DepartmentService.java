package com.yck.springbootselflearning.service;

import com.yck.springbootselflearning.dao.Department;

public interface DepartmentService {
    Department getDeptById(Integer id);
    Department saveDept(Department department);
    void deleteDeptById(Integer id);
}
