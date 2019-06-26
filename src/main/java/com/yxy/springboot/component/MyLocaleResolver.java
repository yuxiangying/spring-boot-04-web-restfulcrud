package com.yxy.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 余想英
 * @version V1.0
 * @ClassName: MyLocaleResolver
 * @Description:TODO(可以在连接携带区域信息)
 * @date: 2019年06月25日 17:32
 * @Copyright: 2019 www.ti-t.cn Inc. All rights reserved.
 * 注意：本内容仅限于福建创昱达信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 **/
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
