package com.yxy.springboot.dao;

import com.yxy.springboot.entities.Department;
import com.yxy.springboot.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author yuxiangying
 * @description TODO
 * @date 2019/6/26
 * @vesion 1.0
 */
@Component
public class EmployeeDao {
    private List<Employee> employees;
    public List<Employee> getAll(){
        employees.add(new Employee(1001, "zhangsan", "1044@qq.com", 1, new Department(1,"A-a") , new Date()));
        employees.add(new Employee(1002, "lisi", "1055@qq.com", 1, new Department(2,"A-b") , new Date()));
        employees.add(new Employee(1003, "wangwu", "1066@qq.com", 0, new Department(3,"A-c") , new Date()));
        employees.add(new Employee(1004, "ermazi", "1077@qq.com", 0, new Department(4,"A-d") , new Date()));
        return employees;
    }
}