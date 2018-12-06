package com.chengql.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用拦截器
 * @Author qlcheng
 * @date 2018/10/23
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        System.out.println("通用拦截器CommonInterceptor【preHandle】被调用:"+((HandlerMethod)object).getBean().getClass().getName());
        System.out.println("通用拦截器CommonInterceptor【preHandle】被调用:"+((HandlerMethod)object).getMethod().getName());
        return true;
    }

    /**
     * 被拦截方法有异常时，此方法不执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
        System.out.println("通用拦截器CommonInterceptor【postHandle】方法被调用");
    }

    /**
     * 此方法无论被调用方法是否出现异常都会执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception e) throws Exception {
        System.out.println("通用拦截器CommonInterceptor【afterCompletion】方法被调用");
    }
}
