package com.forest.mapper;

import com.forest.entity.TransactionRecordDetails;
import com.forest.entity.TransactionRecordDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionRecordDetailsMapper {
    int countByExample(TransactionRecordDetailsExample example);

    int deleteByExample(TransactionRecordDetailsExample example);

    int deleteByPrimaryKey(Integer trdId);

    int insert(TransactionRecordDetails record);

    int insertSelective(TransactionRecordDetails record);

    List<TransactionRecordDetails> selectByExample(TransactionRecordDetailsExample example);

    TransactionRecordDetails selectByPrimaryKey(Integer trdId);

    int updateByExampleSelective(@Param("record") TransactionRecordDetails record, @Param("example") TransactionRecordDetailsExample example);

    int updateByExample(@Param("record") TransactionRecordDetails record, @Param("example") TransactionRecordDetailsExample example);

    int updateByPrimaryKeySelective(TransactionRecordDetails record);

    int updateByPrimaryKey(TransactionRecordDetails record);
    
    List<TransactionRecordDetails> queryAll();
}