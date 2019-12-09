package com.forest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.forest.entity.Jurisdiction;
import com.forest.entity.JurisdictionExample;

public interface JurisdictionMapper {
    int countByExample(JurisdictionExample example);

    int deleteByExample(JurisdictionExample example);

    int deleteByPrimaryKey(Integer jurId);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    List<Jurisdiction> selectByExample(JurisdictionExample example);

    Jurisdiction selectByPrimaryKey(Integer jurId);

    int updateByExampleSelective(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByExample(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);

    
    
    List<Integer> listPermissionIdsByRoleIds(List<Integer> role_ids) ;

    List<Jurisdiction> listPermissionsByPermissionIds(List<Integer> permissions_ids);
    
    
    
}