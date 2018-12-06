package com.chengql.security.core.validate.sms.impl;

import com.chengql.security.core.validate.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认的短信发送器
 * @Author qlcheng
 * @date 2018/11/21
 */
public class DefaultSmsSender implements SmsSender {

    Logger logger = LoggerFactory.getLogger(DefaultSmsSender.class);

    @Override
    public void send(String mobile, String code) {
        logger.info("向手机号码为:"+mobile+"的手机发送验证码，验证码为:"+code);
    }
}
