package com.yxy.springboot.controller;

import com.yxy.springboot.dao.EmployeeDao;
import com.yxy.springboot.entities.Department;
import com.yxy.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;
import java.util.List;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: EmployeeController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年06月26日 17:25
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有的部门，在页面上显示
        List<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面属性一一对应
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        //employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //Employee employee = employeeDao.get(id);
        //model.addAttribute("emp",employee);
        //页面所有部门列表
       // List<Department> departments = departmentDao.getAll();
        //model.addAttribute("depts",departments);
        //回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("保存的员工信息："+employee);
        //employeeDao.save(employee);
        return "redirect:/emps";
    }

}
