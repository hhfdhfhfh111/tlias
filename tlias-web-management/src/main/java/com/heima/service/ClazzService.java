package com.heima.service;

import com.heima.pojo.Clazz;
import com.heima.pojo.ClazzQueryParam;
import com.heima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {

    //1.查询班级列表
    PageResult page(ClazzQueryParam clazzQueryParam);
   //2.增加班级
    void save(Clazz clazz);
   //根据id查询班级信息
    Clazz getByid(Integer id);
    //修改班级信息
    void update(Clazz clazz);

    void delete(Integer id);

    List<Clazz> list();
}
