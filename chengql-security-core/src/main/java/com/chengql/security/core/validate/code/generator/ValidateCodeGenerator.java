package com.chengql.security.core.validate.code.generator;

import com.chengql.security.core.validate.code.bean.BaseValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.Servlet;

/**
 * 验证码生成接口
 * @Author qlcheng
 * @date 2018/11/21
 */
public interface ValidateCodeGenerator {

    /**
     * 生成验证码
     * @param request
     * @return
     */
    public BaseValidateCode generate(ServletWebRequest request);
}
