package com.heima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.pojo.Emp;
import com.heima.pojo.EmpQueryParam;
import com.heima.pojo.LoginInfo;
import com.heima.pojo.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {


    PageResult page(EmpQueryParam empQueryParam);

    //新增员工
    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);


    void update(Emp emp);

    //登录操作
    LoginInfo login(Emp emp);

    List<Emp> list();


//    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin,LocalDate end);


}
