package com.yxy.springboot.dao;

import com.yxy.springboot.entities.Department;
import com.yxy.springboot.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author yuxiangying
 * @description TODO
 * @date 2019/6/26
 * @vesion 1.0
 */
@Component
public class EmployeeDao {
    private static Map<Integer,Employee> employees = null;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001, "zhangsan", "1044@qq.com", 1, new Department(1,"A-a") , new Date()));
        employees.put(1002,new Employee(1002, "lisi", "1055@qq.com", 1, new Department(2,"A-b") , new Date()));
        employees.put(1003,new Employee(1003, "wangwu", "1066@qq.com", 0, new Department(3,"A-c") , new Date()));
        employees.put(1004,new Employee(1004, "ermazi", "1077@qq.com", 0, new Department(4,"A-d") , new Date()));
    }
    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(new Department(5,"E-AA"));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){ return employees.values(); }

    public Employee get(Integer id) { return employees.get(id);}

    public void delete(Integer id){ employees.remove(id);}
}