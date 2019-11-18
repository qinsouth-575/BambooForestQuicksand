package com.forest.mapper;

import com.forest.entity.JurPosRelation;
import com.forest.entity.JurPosRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JurPosRelationMapper {
    int countByExample(JurPosRelationExample example);

    int deleteByExample(JurPosRelationExample example);

    int deleteByPrimaryKey(Integer relId);

    int insert(JurPosRelation record);

    int insertSelective(JurPosRelation record);

    List<JurPosRelation> selectByExample(JurPosRelationExample example);

    JurPosRelation selectByPrimaryKey(Integer relId);

    int updateByExampleSelective(@Param("record") JurPosRelation record, @Param("example") JurPosRelationExample example);

    int updateByExample(@Param("record") JurPosRelation record, @Param("example") JurPosRelationExample example);

    int updateByPrimaryKeySelective(JurPosRelation record);

    int updateByPrimaryKey(JurPosRelation record);
}