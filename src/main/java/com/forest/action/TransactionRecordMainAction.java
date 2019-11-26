package com.forest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.TransactionRecordMainBiz;
import com.forest.entity.TransactionRecordMain;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("TransactionRecordMain")
public class TransactionRecordMainAction {
					@Autowired
					private TransactionRecordMainBiz transactionRecordMainBiz;
					
					
					/**
					 * 成交记录表分页查询(多条件)
					 * @param pageNum
					 * @return
					 */
					@RequestMapping("queryAll")
					@ResponseBody
					public PageInfo<TransactionRecordMain> queryAll(@RequestBody TransactionRecordMain t){
						return transactionRecordMainBiz.queryAll(t);
					}

}
