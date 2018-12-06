package com.chengql.test.service.impl;

import com.chengql.test.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @Author qlcheng
 * @date 2018/10/19
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public boolean test(String msg) {
        System.out.println("你好:"+msg);
        return true;
    }
}
