package com.chengql.security.core.validate.code.generator;

import com.chengql.security.core.validate.code.bean.BaseValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author qlcheng
 * @date 2018/11/21
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Override
    public BaseValidateCode generate(ServletWebRequest request) {
        return new BaseValidateCode("123456",100);
    }
}
