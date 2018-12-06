package com.chengql.web.controller;

import com.chengql.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理Controller抛出的异常
 * @Author qlcheng
 * @date 2018/10/23
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    /**
     * UserNoteExitsException异常由此方法处理
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handlerUserNoteExistException(UserNotExistException userNoteExistException){
        Map<String,Object> exception = new HashMap<>();
        exception.put("id",userNoteExistException.getId());
        exception.put("msg",userNoteExistException.getMessage());
        return exception;
    }
}
