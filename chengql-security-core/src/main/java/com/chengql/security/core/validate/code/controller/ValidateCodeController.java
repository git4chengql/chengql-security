package com.chengql.security.core.validate.code.controller;

import com.chengql.security.core.validate.ValidateCodeProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码控制器
 * @Author qlcheng
 * @date 2018/11/14
 */
@RestController
public class ValidateCodeController {


    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    /**
     * 图形验证码
     * @param request
     * @param response
     */
    @GetMapping("/code/image")
    public void generateImage(HttpServletRequest request, HttpServletResponse response){

    }

    /**
     * 短信验证码
     * @param request
     * @param response
     */
    @GetMapping("/code/{type}")
    public void create(HttpServletRequest request, HttpServletResponse response,@PathVariable String type) throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }
}
