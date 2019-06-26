package com.yxy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: HelloController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年06月24日 9:39
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
@Controller
public class HelloController {

    /*@RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    //查出一些数据，在页面展示
    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success.html
        return "success";
    }
}
