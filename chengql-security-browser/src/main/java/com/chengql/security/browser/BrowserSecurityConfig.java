package com.chengql.security.browser;

import com.chengql.security.browser.authentication.MyAuthenticationFailureHandler;
import com.chengql.security.browser.authentication.MyAuthenticationSuccessHandler;
import com.chengql.security.core.properties.SecurityProperties;
import com.chengql.security.core.validate.code.filter.ValidateBeforeAuthenticationFilter;
import com.chengql.security.core.validate.config.SmsCodeAuthencationFilterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


/**
 * 浏览器安全配置类
 * @Author qlcheng
 * @date 2018/10/23
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(BrowserSecurityConfig.class);

    /**
     * 系统配置类
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService myUserDetailsService;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    /**
     * 登录成功处理器
     */
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    /**
     * 认证失败处理器
     */
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthencationFilterConfig smsCodeAuthencationFilterConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

             //http.addFilterBefore()可通过增加自定义过滤器的方式增加自定义逻辑
        ValidateBeforeAuthenticationFilter filter = new ValidateBeforeAuthenticationFilter();

        filter.afterPropertiesSet();

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //自定义表单登录页
                .loginPage("/login")
                //自定义登录提交URL
                .loginProcessingUrl("/authentication/form")
                //登录成功处理器
                .successHandler(myAuthenticationSuccessHandler)
                //登录失败处理器
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                //记住我功能
                .rememberMe()
                //设置token的存储数据源
                .tokenRepository(persistentTokenRepository())
                //设置token的有效时长
                .tokenValiditySeconds(360)
                //设置根据token查询用户信息的服务
                .userDetailsService(myUserDetailsService)
                .and()
                //请求的认证
                .authorizeRequests()
                //不需要认证的URL
                .antMatchers("/code/*","/login","/authentication/mobile",securityProperties.getBrowser().getLoginPage()).permitAll()
                //任何请求
                .anyRequest()
                //都需要身份认证
                .authenticated()
                //暂停CSRF攻击
                .and()
                .csrf().disable().apply(smsCodeAuthencationFilterConfig);
    }
}
