package com.chen.controller;

import com.chen.domain.Department;
import com.chen.domain.Employee;
import com.chen.service.IDepartmentService;
import com.chen.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询所有员工信息并跳转页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        List<Employee> employeeList = employeeService.queryAll();
        model.addAttribute("empList", employeeList);
        return "/emp/empinfor";
    }

    /**
     * 新增/修改跳转页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/input")
    public String input(Model model,Long id){
        // 判断id是否为空
        if (Objects.nonNull(id)) {
            Employee employee = employeeService.getById(id);
            // 将员工信息返回到前端
            model.addAttribute("employee", employee);
        }
        // 查询所有部门，并将部门信息返回给页面
        List<Department> departments = departmentService.selectAll();
        model.addAttribute("depts", departments);
        return "emp/empsave";
    }

    /**
     * 新增/修改保存
     * @param employee
     * @return
     */
    @RequestMapping("/save")
    public String save(Employee employee) {
        // 判断id是否为空
        if (Objects.nonNull(employee.getId())) {
            // 修改操作
            employeeService.update(employee);
        } else {
            // 新增操作
            employeeService.insert(employee);
        }
        return "redirect:/emp/index";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable("id")Long id) {
        employeeService.deleteById(id);
        return "redirect:/emp/index";
    }


    /**
     * 获取json数据
     * @param model
     * @return
     */
    @RequestMapping("/empslist")
    @ResponseBody
    public List<Employee> queryAll(Model model) {
        List<Employee> employeeList = employeeService.queryAll();
//        model.addAttribute("emplist", employeeList);
        return employeeList;
    }
}
