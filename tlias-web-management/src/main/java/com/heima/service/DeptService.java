package com.heima.service;

import com.heima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;








public interface DeptService {



    public List<Dept> findAll();

    void deteleByid(Integer id);

    void add(Dept dept);

    Dept getByid(Integer id);

    void update(Dept dept);
}
