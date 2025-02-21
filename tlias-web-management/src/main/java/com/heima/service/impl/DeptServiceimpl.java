package com.heima.service.impl;


import com.heima.mapper.DeptMapper;
import com.heima.pojo.Dept;
import com.heima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }


    @Override
    public void deteleByid(Integer id) {
        deptMapper.deleteByid(id);
    }

    @Override
    public void add(Dept dept) {
        //1.补全基础属性
      dept.setCreateTime(LocalDateTime.now());
      dept.setUpdateTime(LocalDateTime.now());


        //2.调用mapper接口方法
    deptMapper.insert(dept);

    }

    @Override
    public Dept getByid(Integer id) {
        return deptMapper.getByid(id);
    }


    @Override
    public void update(Dept dept) {
        //1.补全基础属性

        dept.setUpdateTime(LocalDateTime.now());
        //2.调用mapper接口方法
        deptMapper.update(dept);
    }
}
