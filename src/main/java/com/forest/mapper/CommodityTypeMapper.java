package com.forest.mapper;

import com.forest.entity.CommodityType;
import com.forest.entity.CommodityTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityTypeMapper {
    int countByExample(CommodityTypeExample example);

    int deleteByExample(CommodityTypeExample example);

    int deleteByPrimaryKey(Integer ctId);

    int insert(CommodityType record);

    int insertSelective(CommodityType record);

    List<CommodityType> selectByExample(CommodityTypeExample example);

    CommodityType selectByPrimaryKey(Integer ctId);

    int updateByExampleSelective(@Param("record") CommodityType record, @Param("example") CommodityTypeExample example);

    int updateByExample(@Param("record") CommodityType record, @Param("example") CommodityTypeExample example);

    int updateByPrimaryKeySelective(CommodityType record);

    int updateByPrimaryKey(CommodityType record);
}