package com.heima.controller;


import com.heima.pojo.PageResult;
import com.heima.pojo.Result;
import com.heima.pojo.Student;
import com.heima.pojo.StudentQueryParam;
import com.heima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    //1.分页查询学员信息
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询:{}", studentQueryParam);
        PageResult pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    //2.添加学员信息
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("添加学员信息:{}", student);
        studentService.save(student);
        return Result.success();
    }

    //3.根据id查询学员信息
    @GetMapping("/{id}")
    public  Result getInfo(@PathVariable Integer id){
        log.info("根据id查询学员信息:",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
    //4.修改学员信息
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息:{}", student);
        studentService.update(student);
        return Result.success();
    }
    //5.批量删除学员信息
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学员信息:{}",ids);
        studentService.delete(ids);
        return Result.success();
    }
    //6.违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violationHandle(@PathVariable Integer id , @PathVariable Integer score){
        studentService.violationHandle(id, score);
        return Result.success();
    }
}
