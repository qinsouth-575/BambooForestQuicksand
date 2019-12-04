package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.TransactionRecordDetailsBiz;
import com.forest.entity.TransactionRecordDetails;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("TransactionRecordDetails")
public class TransactionRecordDetailsAction {
				@Autowired
				private TransactionRecordDetailsBiz transactionRecordDetailsBiz;
				
				/**
				 * 按商品进行成交记录分页查询
				 * @param pageNum
				 * @return
				 */
				@RequestMapping("queryAll")
				@ResponseBody
				public PageInfo<TransactionRecordDetails> queryAll(@RequestBody TransactionRecordDetails d){
					return transactionRecordDetailsBiz.queryAll(d);
				}
}
