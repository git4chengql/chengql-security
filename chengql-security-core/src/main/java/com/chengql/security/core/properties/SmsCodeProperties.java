package com.chengql.security.core.properties;

/**
 * 短信验证码系统属性配置
 * @Author qlcheng
 * @date 2018/11/30
 */
public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;

    private String url;

    public int getLength() {
        return length;
    }
    public void setLength(int lenght) {
        this.length = lenght;
    }
    public int getExpireIn() {
        return expireIn;
    }
    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
