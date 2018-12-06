package com.chengql.security.core.config;

import com.chengql.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 此类的作用是:
 *      使SecurityProperties生效
 * @Author qlcheng
 * @date 2018/10/23
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
