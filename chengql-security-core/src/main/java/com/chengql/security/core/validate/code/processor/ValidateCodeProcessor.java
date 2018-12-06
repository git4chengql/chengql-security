package com.chengql.security.core.validate.code.processor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码接口
 *   1、生成不同的校验码
 *   2、保存生成的校验码
 * @Author qlcheng
 * @date 2018/11/14
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建验证码
     * @param request
     * @throws Exception
     */
    public void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    public void validate(ServletWebRequest servletWebRequest);
}
