package com.chengql.security.core.validate.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author qlcheng
 * @date 2018/11/27
 */
public class ValidateCodeException extends AuthenticationException {
    /**
     *
     */
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
