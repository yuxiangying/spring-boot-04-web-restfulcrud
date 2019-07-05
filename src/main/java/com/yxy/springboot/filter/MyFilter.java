package com.yxy.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: MyFilter
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @date: 2019年07月05日 14:01
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
