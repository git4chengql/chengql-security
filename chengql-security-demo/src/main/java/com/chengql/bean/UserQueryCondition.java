package com.chengql.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author qlcheng
 * @date 2018/10/19
 */
public class UserQueryCondition {

    @ApiModelProperty(value = "用户名(查询条件)")
    private String userName;
    private int age;
    private int ageTo;
    private String xxx;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
