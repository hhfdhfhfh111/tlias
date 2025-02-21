package com.heima.controller;


import com.heima.pojo.OperateLogParam;
import com.heima.pojo.PageResult;
import com.heima.pojo.Result;
import com.heima.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/logs")
public class LogController {


    @Autowired
    private OperateLogService operateLogService;
    @GetMapping("/page")
    public Result page(OperateLogParam operateLogParam){
        log.info("查询操作日志:{}",operateLogParam);
        PageResult pageResult = operateLogService.page(operateLogParam);
        return Result.success(pageResult);
    }
}
