package com.chen.service.impl;

import com.chen.domain.Employee;
import com.chen.mapper.EmployeeMapper;
import com.chen.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Transactional
    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    public Employee getById(Long id) {
        return employeeMapper.getById(id);
    }

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        HashMap<String, Object> result = new HashMap<>();
        // 1 校验参数是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.put("success", false);
            result.put("message", "用户名或密码不正确！");
            return result;
        }

        // 2 通过username查询员工信息
        Employee employee = employeeMapper.login(username);
        // 3 判断员工信息是否存在
        if (Objects.isNull(employee)) {
            // 不存在，说明用户名错误
            result.put("success", false);
            result.put("message", "用户名或密码错误！");
            return result;
        }

        // 3 存在判断密码是否一致
        if (!password.equals(employee.getPassword())) {
            result.put("success", false);
            result.put("message", "用户名或密码错误！");
            return result;
        }
        // 密码一致
        result.put("success", true);
        result.put("message", "登录成功！");
        result.put("data", employee);
        return result;
    }
}
