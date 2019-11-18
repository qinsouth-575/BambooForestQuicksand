package com.forest.mapper;

import com.forest.entity.PurchaseMain;
import com.forest.entity.PurchaseMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseMainMapper {
    int countByExample(PurchaseMainExample example);

    int deleteByExample(PurchaseMainExample example);

    int deleteByPrimaryKey(Integer pmId);

    int insert(PurchaseMain record);

    int insertSelective(PurchaseMain record);

    List<PurchaseMain> selectByExample(PurchaseMainExample example);

    PurchaseMain selectByPrimaryKey(Integer pmId);

    int updateByExampleSelective(@Param("record") PurchaseMain record, @Param("example") PurchaseMainExample example);

    int updateByExample(@Param("record") PurchaseMain record, @Param("example") PurchaseMainExample example);

    int updateByPrimaryKeySelective(PurchaseMain record);

    int updateByPrimaryKey(PurchaseMain record);
}