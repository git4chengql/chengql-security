package com.chengql.config;

import com.chengql.interceptor.CommonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 系统配置入口
 * @Author qlcheng
 * @date 2018/10/23
 */
@Configuration
public class SystemConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private CommonInterceptor commonInterceptor;

    /**
     * 注册自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor);
    }

}
