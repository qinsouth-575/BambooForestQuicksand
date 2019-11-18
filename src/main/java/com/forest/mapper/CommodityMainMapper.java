package com.forest.mapper;

import com.forest.entity.CommodityMain;
import com.forest.entity.CommodityMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityMainMapper {
    int countByExample(CommodityMainExample example);

    int deleteByExample(CommodityMainExample example);

    int deleteByPrimaryKey(Integer cmId);

    int insert(CommodityMain record);

    int insertSelective(CommodityMain record);

    List<CommodityMain> selectByExample(CommodityMainExample example);

    CommodityMain selectByPrimaryKey(Integer cmId);

    int updateByExampleSelective(@Param("record") CommodityMain record, @Param("example") CommodityMainExample example);

    int updateByExample(@Param("record") CommodityMain record, @Param("example") CommodityMainExample example);

    int updateByPrimaryKeySelective(CommodityMain record);

    int updateByPrimaryKey(CommodityMain record);
}