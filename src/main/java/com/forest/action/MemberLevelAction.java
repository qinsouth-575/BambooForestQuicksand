package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.MemberLevelBiz;
import com.forest.entity.MemberLevel;

@Controller
@RequestMapping("MemberLevel")
public class MemberLevelAction {
				@Autowired
				private MemberLevelBiz memberLevelBiz;
				
				/**
				 * 查询所有会员等级信息
				 * @return
				 */
				@RequestMapping("/queryAll")
				@ResponseBody
				public List<MemberLevel> queryAll(){
					return memberLevelBiz.queryAll();
				}
				
				/**
				 * 新增会员等级
				 * @param ml
				 * @return
				 */
				@RequestMapping(value="/insertAll",method = RequestMethod.POST)
				@ResponseBody
				public Map<String, String> insertAll(@RequestBody MemberLevel ml){
					Map<String, String> map=new HashMap<String, String>();
					boolean b=memberLevelBiz.insertAll(ml);
					if(b) {
						map.put("msg", "新增成功！");
					}else {
						map.put("msg", "新增失败！");
					}
					return map;
				}
				
				/**
				 * 根据等级编号查询等级信息
				 * @param mlId
				 * @return
				 */
				@RequestMapping("/queryById")
				@ResponseBody
				public MemberLevel queryById(int mlId) {
					return memberLevelBiz.queryById(mlId);
				}
				
				/**
				 * 根据等级编号修改等级信息
				 * @param ml
				 * @return
				 */
				@RequestMapping(value = "/updateAll",method = RequestMethod.PUT)
				@ResponseBody
				public Map<String, String> updateAll(@RequestBody MemberLevel ml){
					Map<String, String> map=new HashMap<String, String>();
					boolean b=memberLevelBiz.updateAll(ml);
					if(b) {
						map.put("msg", "修改成功！");
					}else {
						map.put("msg", "修改失败！");
					}
					return map;
				}
}
