package com.heima.mapper;


import com.heima.pojo.Student;
import com.heima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    Integer countByClazzId(Integer id);

    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void updateViolation(Integer id, Integer score);

    @MapKey("name")
    List<Map> countStudentDegreeData();

    @MapKey("scout")
    List<Map<String, Object>> getStudentCount();
}
