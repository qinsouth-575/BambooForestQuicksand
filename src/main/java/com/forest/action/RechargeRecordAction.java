package com.forest.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.RechargeRecordBiz;
import com.forest.entity.RechargeRecord;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("RechargeRecord")
public class RechargeRecordAction {
				@Autowired
				private RechargeRecordBiz rechargeRecordBiz;
				
				/**
				 * 充值抵扣分页查询
				 * @param pageNum
				 * @return
				 */
				@RequestMapping("/queryAll")
				@ResponseBody
				public PageInfo<RechargeRecord> queryAll(@RequestBody RechargeRecord r){
					return rechargeRecordBiz.queryAll(r);
				}
				
				/**
				 * 
				 * 充值要先查询会员编号是否存在 如果存在就修改会员余额(充值) 然后再添加充值抵扣记录
				 * 
				 */
				/**
				 * 新增充值抵扣表记录
				 * @param r
				 * @return
				 */
				@RequestMapping(value = "/insertAll",method = RequestMethod.POST)
				@ResponseBody
				public Map<String, String> insertAll(@RequestBody RechargeRecord r){
					Map<String, String> map =new HashMap<String, String>();
					boolean b=rechargeRecordBiz.insertAll(r);
					if(b) {
						map.put("msg", "新增成功！");
					}else {
						map.put("msg", "新增失败！");
					}
					return map;
				}
				
}
