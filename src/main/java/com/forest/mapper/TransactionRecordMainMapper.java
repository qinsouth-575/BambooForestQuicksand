package com.forest.mapper;

import com.forest.entity.TransactionRecordMain;
import com.forest.entity.TransactionRecordMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionRecordMainMapper {
    int countByExample(TransactionRecordMainExample example);

    int deleteByExample(TransactionRecordMainExample example);

    int deleteByPrimaryKey(Integer trmId);

    int insert(TransactionRecordMain record);

    int insertSelective(TransactionRecordMain record);

    List<TransactionRecordMain> selectByExample(TransactionRecordMainExample example);

    TransactionRecordMain selectByPrimaryKey(Integer trmId);

    int updateByExampleSelective(@Param("record") TransactionRecordMain record, @Param("example") TransactionRecordMainExample example);

    int updateByExample(@Param("record") TransactionRecordMain record, @Param("example") TransactionRecordMainExample example);

    int updateByPrimaryKeySelective(TransactionRecordMain record);

    int updateByPrimaryKey(TransactionRecordMain record);
    
    List<TransactionRecordMain> queryAll(TransactionRecordMain t);
    
    List<TransactionRecordMain> queryByPage();
    
    int insertAllGd(TransactionRecordMain tm);
    
    List<TransactionRecordMain> queryByDd();
    
    int deleteById(String orderNumber);
    
    TransactionRecordMain queryById(String orderNumber);
    
    int updateByAll(TransactionRecordMain trm);
}