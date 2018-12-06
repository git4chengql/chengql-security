package com.chengql.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 * 验证SpringBoot中过滤器在请求中的位置
 * @Author qlcheng
 * @date 2018/10/23
 */
@Component
public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("自定义过滤器初始化方法被调用");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("自定义过滤器doFilter方法被调用");
        System.out.println("自定义过滤器请求的URL为:"+((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("自定义过滤器destroy方法被调用");
    }
}

