package com.forest.mapper;

import com.forest.entity.PurchaseDetails;
import com.forest.entity.PurchaseDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PurchaseDetailsMapper {
	List<PurchaseDetails> queryDId(String pm_id);
	
    int countByExample(PurchaseDetailsExample example);

    int deleteByExample(PurchaseDetailsExample example);

    int deleteByPrimaryKey(Integer pdId);

    int insert(PurchaseDetails record);

    int insertSelective(PurchaseDetails record);

    List<PurchaseDetails> selectByExample(PurchaseDetailsExample example);

    PurchaseDetails selectByPrimaryKey(Integer pdId);

    int updateByExampleSelective(@Param("record") PurchaseDetails record, @Param("example") PurchaseDetailsExample example);

    int updateByExample(@Param("record") PurchaseDetails record, @Param("example") PurchaseDetailsExample example);

    int updateByPrimaryKeySelective(PurchaseDetails record);

    int updateByPrimaryKey(PurchaseDetails record);
}