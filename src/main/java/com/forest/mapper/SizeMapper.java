package com.forest.mapper;

import com.forest.entity.Size;
import com.forest.entity.SizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SizeMapper {
    int countByExample(SizeExample example);

    int deleteByExample(SizeExample example);

    int deleteByPrimaryKey(Integer sizeId);

    int insert(Size record);

    int insertSelective(Size record);

    List<Size> selectByExample(SizeExample example);

    Size selectByPrimaryKey(Integer sizeId);

    int updateByExampleSelective(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByExample(@Param("record") Size record, @Param("example") SizeExample example);

    int updateByPrimaryKeySelective(Size record);

    int updateByPrimaryKey(Size record);
    
    int selectSizeIdCount(Integer sizeId);
}