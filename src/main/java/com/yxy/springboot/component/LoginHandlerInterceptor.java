package com.yxy.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: LoginHandlerInterceptor
 * @Description:TODO(登录检查)
 * @date: 2019年06月26日 11:06
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user ==null ){
            //未登录，返回登录页面
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            //已登录，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
