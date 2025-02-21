package com.heima.controller;


import com.heima.anno.Log;
import com.heima.pojo.Emp;
import com.heima.pojo.EmpQueryParam;
import com.heima.pojo.PageResult;
import com.heima.pojo.Result;
import com.heima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    //查询员工
    @Autowired
    private EmpService empService;


    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
            log.info("分页查询:{}",empQueryParam);
            PageResult pageResult = empService.page(empQueryParam);
            return Result.success(pageResult);
    }

    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //删除员工
    @DeleteMapping

    public Result delete(@RequestParam List<Integer> ids){
        log.info("根据id批量删除员工:{}",ids);
        empService.delete(ids);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
            log.info("根据id查询员工信息");
            Emp emp = empService.getInfo(id);
            return Result.success(emp);
    }

    @PutMapping

    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        log.info("查询全部员工:");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }



}
