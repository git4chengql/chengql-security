package com.chengql.web.controller;

import com.chengql.bean.User;
import com.chengql.bean.UserQueryCondition;
import com.chengql.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 * @Author qlcheng
 * @date 2018/10/17
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 获取用户信息
     *   SpringSecurity过滤器链的最前端过滤器为
     *     SecurityContextPersistenceFilter,多个请求之间共享用户信息的实现方式为
     *     请求在SecurityContextPersistenceFilter后置的范围内是将用户信息放在线程中的
     *     当请求出SecurityContextPersistenceFilter的时候，SpringSecurity回从线程中
     *     将用户信息拿出并放置到Session中
     * @return
     */
    @GetMapping("/me1")
    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }


    /**
     * 查询用户
     * @param pageable 分页参数
     * @return
     */
    @GetMapping
    @ApiOperation(value = "用户查询服务")
    public List<User> getAllUser(UserQueryCondition condition, @PageableDefault(page = 2, size = 17, sort = "username,asc")Pageable pageable){
        //打印查询条件
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public User getUserById(@PathVariable(name = "id") String userId){
        throw new UserNotExistException(userId);
//        User user = new User();
//        user.setId(userId);
//        user.setUserName("nba");
       // return user;
    }

    /**
     * 创建用户
     * @param user
     * @param errors
     * @return
     */
    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult errors){
        //如果验证有错误,打印错误信息
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(objectError -> System.out.println("错误:"+objectError.getDefaultMessage()));
            return null;
        }
        user.setId("1");
        System.out.println(user.getUserName());
        return user;
    }
}
