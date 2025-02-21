package com.heima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.exception.DeleteClassException;
import com.heima.mapper.ClazzMapper;
import com.heima.mapper.StudentMapper;
import com.heima.pojo.Clazz;
import com.heima.pojo.ClazzQueryParam;
import com.heima.pojo.PageResult;
import com.heima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceimpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        //2.执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        //3.解析查询结构，并封装
        Page<Clazz> p=(Page<Clazz>) clazzList;
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Clazz clazz) {
         //1.补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        //2.保存班级基本信息
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getByid(Integer id) {
        return clazzMapper.getByid(id);
    }

    @Override
    public void update(Clazz clazz) {
        //1.补全基础属性
        clazz.setUpdateTime(LocalDateTime.now());
        //2.调用mapper接口方法
        clazzMapper.update(clazz);
    }


    @Override
    public void delete(Integer id) {
        //1.查询班级下是否有学员
        Integer count = studentMapper.countByClazzId(id);
        if (count > 0) {
            throw new DeleteClassException("班级下有学员，不能直接删除");
        }
        clazzMapper.deleteByid(id);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.findAll();
    }
}
