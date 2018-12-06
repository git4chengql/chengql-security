package com.chengql.security.core.validate.sms;

import com.chengql.security.core.validate.code.bean.BaseValidateCode;
import com.chengql.security.core.validate.code.processor.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author qlcheng
 * @date 2018/11/27
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<BaseValidateCode> {

    @Autowired
    private SmsSender smsSender;

    @Override
    protected void send(ServletWebRequest request, BaseValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
        smsSender.send(mobile, validateCode.getCode());
    }
}
