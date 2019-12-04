package com.forest.mapper;

import com.forest.entity.CommodityMD;
import com.forest.entity.PurchaseDetails;
import com.forest.entity.PurchaseMain;
import com.forest.entity.PurchaseMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PurchaseMainMapper {
    int countByExample(PurchaseMainExample example);

    int deleteByExample(PurchaseMainExample example);

    int deleteByPrimaryKey(Integer pmId);

    int insert(PurchaseMain record);

    int insertSelective(PurchaseMain record);

    List<PurchaseMain> selectByExample(PurchaseMainExample example);

    PurchaseMain selectByPrimaryKey(Integer pmId);

    int updateByExampleSelective(@Param("record") PurchaseMain record, @Param("example") PurchaseMainExample example);

    int updateByExample(@Param("record") PurchaseMain record, @Param("example") PurchaseMainExample example);

    int updateByPrimaryKeySelective(PurchaseMain record);

    int updateByPrimaryKey(PurchaseMain record);
    
    //查询所有供应商
    List<PurchaseMain> queryAll(PurchaseMain pm);
    
    //查询单号
    int queryCountBill(String pmOdd);
    
    //根据复选框选中的Id添加到采购单
    CommodityMD queryId(int id);
    //新增主表
    int insertM(PurchaseMain pm);
    //新增详表
    int insertD(@Param("list") List<PurchaseDetails> list);
    //修改主表
    int updateM(PurchaseMain pm);
    //删除主表
    int deleteM(int id);
    //删除详表
    int deleteD(String pmOdd);
    
    int deleteMD(int id);
    //根据Id查询对应的数据
    PurchaseMain queryMId(int pm_id);
    //修改状态
    int updateStatu(int id);
}