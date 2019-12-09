package com.forest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.TransactionRecordDetailsBiz;
import com.forest.biz.TransactionRecordMainBiz;
import com.forest.entity.TransactionRecordDetails;
import com.forest.entity.TransactionRecordMain;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("TransactionRecordMain")
public class TransactionRecordMainAction {
					@Autowired
					private TransactionRecordMainBiz transactionRecordMainBiz;
					
					@Autowired
					private TransactionRecordDetailsBiz transactionRecordDetailsBiz;
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
					
					/**
					 * 挂单
					 * @param tm
					 * @return
					 */
					@RequestMapping(value = "/insertAllGd",method = RequestMethod.POST)
					@ResponseBody
					public Map<String, String> insertAllGd(@RequestBody TransactionRecordMain tm){
						boolean b=transactionRecordMainBiz.insertAllGd(tm);
						boolean bl=transactionRecordDetailsBiz.insertByDetails(tm.getDetails());
						Map<String, String> map=new HashMap<String, String>();
						if(b) {
							if(bl) {
							map.put("msg", "挂单成功");
							}else {
								map.put("msg", "挂单失败");
							}
						}else {
							map.put("msg", "挂单失败");
						}
						return map;
					}
					
					/**
					 * 查询所有挂单
					 * @return
					 */
					@RequestMapping("queryByDd")
					@ResponseBody
					public List<TransactionRecordMain> queryByDd(){
						return transactionRecordMainBiz.queryByDd();
					}
					
					/**
					 * 根据订单号删除挂单
					 * @param orderNumber
					 * @return
					 */
					@RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
					@ResponseBody
					public Map<String, String> deleteById(String orderNumber) {
						boolean b=transactionRecordMainBiz.deleteById(orderNumber);
						boolean bl=transactionRecordDetailsBiz.deleteById(orderNumber);
						Map<String, String> map=new HashMap<String, String>();
						if(bl) {
							if(b) {
								map.put("msg", "删除成功");
							}else {
								map.put("msg", "删除失败");
							}
						}else {
							map.put("msg", "删除失败");
						}
						return map;
					}
					
					/**
					 * 根据订单号查询
					 * @param orderNumber
					 * @return
					 */
					@RequestMapping("queryById")
					@ResponseBody
					public TransactionRecordMain queryById(String orderNumber) {
						TransactionRecordMain trm=transactionRecordMainBiz.queryById(orderNumber);
						List<TransactionRecordDetails> trd=transactionRecordDetailsBiz.queryById(orderNumber);
						trm.setDetails(trd);
						return trm;
					}
}
