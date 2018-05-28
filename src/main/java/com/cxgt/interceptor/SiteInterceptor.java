package com.cxgt.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.Site;
import com.cxgt.service.SiteService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Gallrax
 * @Description: Site拦截器，通过查询域名注入session
 * @Date: 2018/5/26
 */
public class SiteInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = Logger.getLogger(SiteInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        SiteService siteService = applicationContext.getBean(SiteService.class);
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        LOGGER.info(" uri : "+ uri + " url : "+ url);
        Site site = siteService.selectById(1);
        if (ObjectUtil.isNotNull(site)) {
            request.getSession().setAttribute(GlobalConstant.SESSION_SITE, site);
        }
        return super.preHandle(request, response, handler);
    }
}
