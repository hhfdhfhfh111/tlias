package com.heima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.mapper.OperateLogMapper;
import com.heima.pojo.OperateLog;
import com.heima.pojo.OperateLogParam;
import com.heima.pojo.PageResult;
import com.heima.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperateLogServiceimpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult page(OperateLogParam operateLogParam) {
        //1.设置分页参数
        PageHelper.startPage(operateLogParam.getPage(),operateLogParam.getPageSize());
        //2.执行查询
        List<OperateLog> operateLogList = operateLogMapper.list(operateLogParam);
        //3.解析查询结果，并封装
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;
        return new PageResult(p.getTotal(),p.getResult());

    }
}
