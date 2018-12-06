package com.chengql.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全配置类
 * @Author qlcheng
 * @date 2018/10/23
 */
@ConfigurationProperties(prefix = "chengql.security")
public class SecurityProperties {
    /**
     * 浏览器配置类
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置类
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
