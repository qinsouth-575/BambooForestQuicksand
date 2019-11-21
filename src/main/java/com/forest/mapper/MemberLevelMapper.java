package com.forest.mapper;

import com.forest.entity.MemberLevel;
import com.forest.entity.MemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLevelMapper {
    int countByExample(MemberLevelExample example);

    int deleteByExample(MemberLevelExample example);

    int deleteByPrimaryKey(Short mlId);

    int insert(MemberLevel record);

    int insertSelective(MemberLevel record);

    List<MemberLevel> selectByExample(MemberLevelExample example);

    MemberLevel selectByPrimaryKey(Short mlId);

    int updateByExampleSelective(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    int updateByExample(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    int updateByPrimaryKeySelective(MemberLevel record);

    int updateByPrimaryKey(MemberLevel record);
    
    List<MemberLevel> queryAll();
    
    int insertAll(MemberLevel ml);
    
    MemberLevel queryById(int mlId);
    
    int updateAll(MemberLevel ml);
}