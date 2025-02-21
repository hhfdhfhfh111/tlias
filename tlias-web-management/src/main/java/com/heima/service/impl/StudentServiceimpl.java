package com.heima.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.mapper.StudentMapper;
import com.heima.pojo.PageResult;
import com.heima.pojo.Student;
import com.heima.pojo.StudentQueryParam;
import com.heima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult page(StudentQueryParam studentQueryParam) {

        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.list(studentQueryParam);
        Page<Student> p=(Page<Student>) studentList;
        return new PageResult(p.getTotal(),p.getResult());


    }

    @Override
    public void save(Student student) {
        //1.补全基础信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        studentMapper.insert(student);

    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(List<Integer> ids) {

        studentMapper.delete(ids);
    }

    @Override
    public void violationHandle(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
