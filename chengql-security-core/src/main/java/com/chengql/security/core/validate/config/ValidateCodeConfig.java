package com.chengql.security.core.validate.config;

import com.chengql.security.core.validate.sms.SmsSender;
import com.chengql.security.core.validate.sms.impl.DefaultSmsSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean生成配置
 * @Author qlcheng
 * @date 2018/11/21
 */
@Configuration
public class ValidateCodeConfig {

    /**
     * 当无SmsSender的实现类时使用Default
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsSender.class)
    public SmsSender smsSender(){
        return new DefaultSmsSender();
    }
}
