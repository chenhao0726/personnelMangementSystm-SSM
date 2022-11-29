package com.chen.service.impl;

import com.chen.BaseTest;
import com.chen.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImplTest extends BaseTest {

    @Autowired
    private IEmployeeService service;

    @Test
    public void testGetById() {
        System.out.println(service.getById(1L));
    }

    @Test
    public void test() {
        System.out.println(service.queryAll());
    }
}