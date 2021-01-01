package com.yck.springbootselflearning.service;

import com.yck.springbootselflearning.bean.Department;
import org.springframework.stereotype.Service;

public interface DepartmentService {
    Department getDeptById(Integer id);
}
