package com.yck.springbootselflearning.repository;

import com.yck.springbootselflearning.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
