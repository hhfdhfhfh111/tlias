package com.heima.controller;


import com.heima.pojo.Clazz;
import com.heima.pojo.ClazzQueryParam;
import com.heima.pojo.PageResult;
import com.heima.pojo.Result;
import com.heima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
   //1.班级列表查询
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result Page(ClazzQueryParam clazzQueryParam){
            log.info("分页查询:{}",clazzQueryParam);
            PageResult pageResult = clazzService.page(clazzQueryParam);
            return Result.success(pageResult);
    }

    //2.添加班级
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("请求参数:{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    //3.根据id查询班级信息
    @GetMapping("/{id}")
    public  Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级信息:",id);
        Clazz clazz = clazzService.getByid(id);
        return Result.success(clazz);
    }

    @PutMapping
    //4.修改班级信息
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }


    //5.删除班级信息
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除班级信息:{}",id);
        clazzService.delete(id);
        return Result.success();
    }

    //6.查询所有班级
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }
}
