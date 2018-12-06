package com.chengql.exception;

/**
 * 自定义异常类
 * @Author qlcheng
 * @date 2018/10/23
 */
public class UserNotExistException extends RuntimeException {
    private String id;

    public UserNotExistException(String id){
        super("用户不存在");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
