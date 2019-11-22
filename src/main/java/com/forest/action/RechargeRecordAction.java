package com.forest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
				public PageInfo<RechargeRecord> queryAll(Integer pageNum){
					return rechargeRecordBiz.queryAll(pageNum);
				}
				
				/**
				 * 
				 * 充值要先查询会员编号是否存在 如果存在就修改会员余额(充值) 然后再添加充值抵扣记录
				 * 
				 */
				
}
