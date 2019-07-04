package com.yxy.springboot.controller;

import com.yxy.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: MyExceptionHandler
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年07月04日 15:12
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
@ControllerAdvice
public class MyExceptionHandler {
    //1.浏览器返回的都是json
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/
    //2.自适应
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx  否则就不会进入定制错误页面的解析流程
        /*Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");*/
       request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","用户出错啦");

        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
