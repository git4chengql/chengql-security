package com.chengql.annotation;

import com.chengql.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * 自定义用户名校验类
 * @Author qlcheng
 * @date 2018/10/19
 * 此类可以使用spring容器中的对象，并且不用在此类中加注@Component,因为此类实现了ConstrainValidator接口
 */
public class UserNameConstraintValidator implements ConstraintValidator<UserCheckAnnotation,String> {

    @Autowired
    private TestService testService;

    @Override
    public void initialize(UserCheckAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return testService.test(value);
    }
}
