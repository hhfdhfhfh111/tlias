package com.heima.service.impl;

import com.heima.mapper.EmpMapper;
import com.heima.mapper.StudentMapper;
import com.heima.pojo.ClazzCountOption;
import com.heima.pojo.JobOption;
import com.heima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;


@Service
public class ReportServiceimpl implements ReportService {

        @Autowired
        private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
        public JobOption getEmpJobData() {
            List<Map<String,Object>> list = empMapper.countEmpJobData();
            List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
            List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
            return new JobOption(jobList, dataList);
        }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> countList = studentMapper.getStudentCount();
        if(!CollectionUtils.isEmpty(countList)){
            List<Object> clazzList = countList.stream().map(map -> {
                return map.get("cname");
            }).toList();

            List<Object> dataList = countList.stream().map(map -> {
                return map.get("scount");
            }).toList();

            return new ClazzCountOption(clazzList, dataList);
        }
        return null;
    }

}
