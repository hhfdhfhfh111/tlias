package com.heima.service;

import com.heima.pojo.PageResult;
import com.heima.pojo.Student;
import com.heima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violationHandle(Integer id, Integer score);
}
