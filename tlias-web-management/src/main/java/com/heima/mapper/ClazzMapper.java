package com.heima.mapper;


import com.heima.pojo.Clazz;
import com.heima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz getByid(Integer id);

    void update(Clazz clazz);

    void deleteByid(Integer id);

    List<Clazz> findAll();
}
