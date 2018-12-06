package com.chengql.security.core.validate.code.bean;

import java.time.LocalDateTime;

/**
 * 验证码基类
 * @Author qlcheng
 * @date 2018/10/25
 */
public class BaseValidateCode {

    private String code;
    private LocalDateTime expireTime;

    public BaseValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public BaseValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
