package com.chen.service.impl;

import com.chen.domain.Department;
import com.chen.mapper.DepartmentMapper;
import com.chen.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
