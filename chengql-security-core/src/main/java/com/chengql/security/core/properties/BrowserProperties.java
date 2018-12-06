package com.chengql.security.core.properties;

/**
 * 浏览器配置类
 * @Author qlcheng
 * @date 2018/10/23
 */
public class BrowserProperties {
    private String loginPage = "/default-singIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
