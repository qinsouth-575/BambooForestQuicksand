package com.forest.mapper;

import com.forest.entity.CmImgRelation;
import com.forest.entity.CmImgRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmImgRelationMapper {
    int countByExample(CmImgRelationExample example);

    int deleteByExample(CmImgRelationExample example);

    int deleteByPrimaryKey(Integer cirId);

    int insert(CmImgRelation record);

    int insertSelective(CmImgRelation record);

    List<CmImgRelation> selectByExample(CmImgRelationExample example);

    CmImgRelation selectByPrimaryKey(Integer cirId);

    int updateByExampleSelective(@Param("record") CmImgRelation record, @Param("example") CmImgRelationExample example);

    int updateByExample(@Param("record") CmImgRelation record, @Param("example") CmImgRelationExample example);

    int updateByPrimaryKeySelective(CmImgRelation record);

    int updateByPrimaryKey(CmImgRelation record);
    
    int deleteCmImgRelationByCmId(Integer cmId);
}