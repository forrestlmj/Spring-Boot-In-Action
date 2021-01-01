package com.yck.springbootselflearning.service.impl;

import com.yck.springbootselflearning.bean.Department;
import com.yck.springbootselflearning.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/1 下午12:54
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getDeptById(Integer id) {
        return new Department(1,"大数据部门");
    }
}
