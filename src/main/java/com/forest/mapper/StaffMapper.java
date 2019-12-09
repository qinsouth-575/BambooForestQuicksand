package com.forest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.forest.entity.Staff;
import com.forest.entity.StaffExample;

public interface StaffMapper {
    int countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    

    List<Integer> listRoleIdsByUserId(Integer id);
    
    Staff findUserByName(@Param("name")String name);
    
    Staff login(@Param("username")String username, @Param("password")String password);
    

    
    List<Staff> queryAll();
    //查询账户密码登录
    Staff queryNameAndPwd(Staff account);
    //根据店铺编号、职位编号、工号查询
    List<Staff> queryShopIdAndPosId(Staff staff);
    //修改账户信息
    int updateStaff(Staff staff);
    //修改头像
    int updateUserByuserpic(Staff staff);
    
}