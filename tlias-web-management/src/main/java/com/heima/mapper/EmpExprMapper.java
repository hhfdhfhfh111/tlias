package com.heima.mapper;


import com.heima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    public void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empids);
}
