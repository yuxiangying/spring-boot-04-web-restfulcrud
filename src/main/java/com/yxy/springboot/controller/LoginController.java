package com.yxy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: LoginController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年06月26日 9:49
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,防止表单重复提交，可以定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误！");
            return "login";
        }

    }
}
