package com.chen.service;

import com.chen.domain.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    void insert(Employee employee);

    void update(Employee employee);

    int deleteById(Long id);

    Employee getById(Long id);

    List<Employee> queryAll();

    Map<String,Object> login(String username, String password);
}
