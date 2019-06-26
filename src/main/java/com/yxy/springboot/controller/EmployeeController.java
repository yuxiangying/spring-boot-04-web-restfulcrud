package com.yxy.springboot.controller;

import com.yxy.springboot.dao.EmployeeDao;
import com.yxy.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
