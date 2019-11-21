package com.forest.mapper;

import com.forest.entity.Setting;
import com.forest.entity.SettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettingMapper {
    int countByExample(SettingExample example);

    int deleteByExample(SettingExample example);

    int deleteByPrimaryKey(Short setId);

    int insert(Setting record);

    int insertSelective(Setting record);

    List<Setting> selectByExample(SettingExample example);

    Setting selectByPrimaryKey(Short setId);

    int updateByExampleSelective(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByExample(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);
    
    Setting queryById();
    
    int updataAll(Setting s);
}