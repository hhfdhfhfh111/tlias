package com.heima.controller;


import com.heima.anno.Log;
import com.heima.pojo.Dept;
import com.heima.pojo.Result;
import com.heima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heima.pojo.Result.success;

@RestController
@RequestMapping("/depts")
public class DeptController {


//   查询部门
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){

        System.out.println("查询全部部门数据");

        List<Dept> deptList = deptService.findAll();

        return success(deptList);

    }
//    删除部门
    //方式一：：比较繁琐
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//
//        String idSr = request.getParameter("id");
//        Integer id = Integer.parseInt(idSr);
//        System.out.println("根据ID删除部门：" + id);
//        return Result.success();
//
//    }


   //方式二
    //注意RequestParam注解 的required属性 默认为true,必须要传递参数
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer Deptid){
//        System.out.println("根据ID删除部门：" + Deptid);
//        return Result.success();
//    }

    //方式三：省略RequestParam注解(前端请求的参数名和服务端方法形参名名一致)


    @DeleteMapping
    public Result delete(Integer id){
        System.out.println("根据ID删除部门：" + id);
        deptService.deteleByid(id);
        return Result.success();
    }



    //新增部门


    @PostMapping
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门:" + dept);
        deptService.add(dept);
        return Result.success();
    }


    //根据id查询部门

    @GetMapping("/{id}")
    public Result getinfo(@PathVariable Integer id){
        System.out.println("根据ID查询部门：" + id);
        Dept dept = deptService.getByid(id);
        return Result.success(dept);
    }




    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门：" + dept);
        deptService.update(dept);
        return Result.success();
    }

}
