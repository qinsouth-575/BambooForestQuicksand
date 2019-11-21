package com.forest.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.Setting;
import com.forest.mapper.SettingMapper;

@Service
@Transactional
public class SettingBiz {
				@Autowired
				private SettingMapper settingmapper;
				
				/**
				 * 查询积分抵扣
				 * @return
				 */
				public Setting queryById() {
					return settingmapper.queryById();
				}
				
				/**
				 * 修改抵扣积分
				 * @param s
				 * @return
				 */
				public boolean updataAll(Setting s) {
					return settingmapper.updataAll(s)>0;
				}
}
