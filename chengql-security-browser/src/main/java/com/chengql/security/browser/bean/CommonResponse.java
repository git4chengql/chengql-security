package com.chengql.security.browser.bean;

/**
 * @Author qlcheng
 * @date 2018/10/23
 */
public class CommonResponse {
    private Object content;

    public CommonResponse(Object o){
        this.content = o;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
