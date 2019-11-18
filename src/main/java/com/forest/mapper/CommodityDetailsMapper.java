package com.forest.mapper;

import com.forest.entity.CommodityDetails;
import com.forest.entity.CommodityDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityDetailsMapper {
    int countByExample(CommodityDetailsExample example);

    int deleteByExample(CommodityDetailsExample example);

    int deleteByPrimaryKey(Integer cdId);

    int insert(CommodityDetails record);

    int insertSelective(CommodityDetails record);

    List<CommodityDetails> selectByExample(CommodityDetailsExample example);

    CommodityDetails selectByPrimaryKey(Integer cdId);

    int updateByExampleSelective(@Param("record") CommodityDetails record, @Param("example") CommodityDetailsExample example);

    int updateByExample(@Param("record") CommodityDetails record, @Param("example") CommodityDetailsExample example);

    int updateByPrimaryKeySelective(CommodityDetails record);

    int updateByPrimaryKey(CommodityDetails record);
}