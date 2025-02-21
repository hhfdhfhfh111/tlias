package com.heima.exception;


import com.heima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }


    //专门处理重复值异常
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
        //处理返回信息
    }

    // 捕获 DeleteClassException 并返回统一错误响应
    @ExceptionHandler(DeleteClassException.class)
    public ResponseEntity<Map<String, Object>> handleDeleteClassException(DeleteClassException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("code", 400); // 业务错误码
        body.put("message", ex.getMessage()); // 错误信息
        return ResponseEntity.badRequest().body(body);
    }


}
