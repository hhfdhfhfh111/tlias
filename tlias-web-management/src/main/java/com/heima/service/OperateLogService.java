package com.heima.service;

import com.heima.pojo.OperateLogParam;
import com.heima.pojo.PageResult;

public interface OperateLogService {

    PageResult page(OperateLogParam operateLogParam);
}
