package com.heima.mapper;

import com.heima.pojo.OperateLog;
import com.heima.pojo.OperateLogParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {


    List<OperateLog> list(OperateLogParam operateLogParam);

    //插入日志数据

    public void insert(OperateLog log);

}
