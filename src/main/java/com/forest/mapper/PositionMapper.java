package com.forest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.forest.entity.Position;
import com.forest.entity.PositionExample;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer posId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer posId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    

    
    List<Position> listRolesByRoleIds(List<Integer> role_ids);
    
    
    
}