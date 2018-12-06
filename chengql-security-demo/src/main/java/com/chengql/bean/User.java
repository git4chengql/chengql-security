package com.chengql.bean;

import com.chengql.annotation.UserCheckAnnotation;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Author qlcheng
 * @date 2018/10/17
 */
public class User {

    @ApiModelProperty(value = "用户标识")
    private String id;

    @NotBlank(message = "用户名不能为空")
    @UserCheckAnnotation(message = "这是一个测试校验注解")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @Past(message = "生日必须是过去的时间")
    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    /**
     * 用户普通视图
     */
    public interface UserSimpleView{};

    /**
     *用户详细视图
     */
    public interface UserDetailView extends  UserSimpleView{};

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
