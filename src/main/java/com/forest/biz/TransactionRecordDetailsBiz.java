package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.TransactionRecordDetails;
import com.forest.entity.TransactionRecordMain;
import com.forest.mapper.TransactionRecordDetailsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TransactionRecordDetailsBiz {
				@Autowired
				private TransactionRecordDetailsMapper transactionRecordDetailsMapper;
				
				
				/**
				 * 按商品进行成交记录分页查询
				 * @param pageNum
				 * @return
				 */
				public PageInfo<TransactionRecordDetails> queryAll(TransactionRecordDetails d){
					PageHelper.startPage(d.getPageNum(),6);
					List<TransactionRecordDetails> list=transactionRecordDetailsMapper.queryAll(d);
					PageInfo<TransactionRecordDetails> page=new PageInfo<TransactionRecordDetails>(list);
					return page;
				}
				
				/**
				 * 新增成交记录详表
				 * @param details
				 * @return
				 */
				public boolean insertByDetails(List<TransactionRecordDetails> details) {
					return transactionRecordDetailsMapper.insertByDetails(details)>0;
				}
				
				
				/**
				 * 根据订单号删除
				 * @param orderNumber
				 * @return
				 */
				public boolean deleteById(String orderNumber) {
						return transactionRecordDetailsMapper.deleteById(orderNumber)>0;
				}
				
				
				/**
				 * 根据订单号查询
				 */
				public List<TransactionRecordDetails> queryById(String orderNumber) {
						return transactionRecordDetailsMapper.queryById(orderNumber);
				}                                                                                                               
}
