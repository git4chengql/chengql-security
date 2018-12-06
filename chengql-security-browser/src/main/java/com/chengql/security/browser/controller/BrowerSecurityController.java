package com.chengql.security.browser.controller;

import com.chengql.security.browser.bean.CommonResponse;
import com.chengql.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理需要登录的请求，根据请求的类型，返回不同的结果。
 * 如：浏览器跳转到页面
 *    App返回JSON数据
 * @Author qlcheng
 * @date 2018/10/23
 */
@RestController
public class BrowerSecurityController {


    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * Spring提供的跳转工具
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(BrowerSecurityController.class);

    /**
     * 系统配置类
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 需要登录时请求此路径
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public CommonResponse login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //SaveRequest对象在RequestCache中存储
        SavedRequest savedRequest = requestCache.getRequest(request,response);

        if(savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的URL为:"+targetUrl);
            //判断引发跳转的URL是不是浏览器发送的，暂以.html模拟
            if(StringUtils.endsWith(targetUrl,".html")){
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        return new CommonResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}
