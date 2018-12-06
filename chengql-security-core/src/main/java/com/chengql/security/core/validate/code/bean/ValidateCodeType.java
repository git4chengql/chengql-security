package com.chengql.security.core.validate.code.bean;

/**
 * 验证码类型
 * @Author qlcheng
 * @date 2018/10/31
 */
public enum  ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS{
        @Override
        public String getParamNameOnValidate() {
            return "MSG";
        }
    },

    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return "IMAG";
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();
}
