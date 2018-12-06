package com.chengql.security.core.validate.sms;

/**
 * 短信验证码发送接口
 * @Author qlcheng
 * @date 2018/11/21
 */
public interface SmsSender {

    /**
     * 发送短信方法
     * @param mobile 手机号
     * @param code  验证码
     */
    void send(String mobile,String code);
}
