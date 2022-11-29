package com.chen.domain;

import java.math.BigDecimal;

public class Employee {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private BigDecimal salary;
    private String address;
    private Department dept;

    public Employee() {
    }

    public Employee(Long id, String name, String password, Integer age, Integer gender, String phone, BigDecimal salary, String address, Department dept) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.salary = salary;
        this.address = address;
        this.dept = dept;
    }

    public Employee(String name, String password, Integer age, Integer gender, String phone, BigDecimal salary, String address, Department dept) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.salary = salary;
        this.address = address;
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
