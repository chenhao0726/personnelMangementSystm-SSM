package com.chen.mapper;

import com.chen.domain.Employee;

import java.util.List;

public interface EmployeeMapper {

    void insert(Employee employee);

    void update(Employee employee);

    int deleteById(Long id);

    Employee getById(Long id);

    List<Employee> queryAll();

    Employee login(String username);
}
