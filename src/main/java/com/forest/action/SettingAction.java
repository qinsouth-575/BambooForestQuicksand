package com.forest.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.SettingBiz;
import com.forest.entity.Setting;

@Controller
@RequestMapping("Setting")
public class SettingAction {
				@Autowired
				private SettingBiz settingBiz;
				
				/**
				 * 查询积分抵扣
				 * @return
				 */
				@RequestMapping("/queryById")
				@ResponseBody
				public Setting queryById() {
					return settingBiz.queryById();
				}
				
				@RequestMapping(value="/updataAll",method = RequestMethod.PUT)
				@ResponseBody
				public Map<String, String> updataAll(@RequestBody Setting s){
					boolean b= settingBiz.updataAll(s);
					Map<String, String> map=new HashMap<String, String>();
					if(b) {
						map.put("msg", "修改成功！");
					}else {
						map.put("msg", "修改失败！");
					}
					return map;
				}
}
