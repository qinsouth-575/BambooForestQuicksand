package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.TransactionRecordMain;
import com.forest.mapper.TransactionRecordMainMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TransactionRecordMainBiz {
				@Autowired
				private TransactionRecordMainMapper transactionRecordMainMapper;
				
				/**
				 * 成交记录分页查询
				 * @param pageNum
				 * @param pageSize
				 * @return
				 */
				public PageInfo<TransactionRecordMain> queryAll(TransactionRecordMain t){
						PageHelper.startPage(t.getPageNum(),6);
						List<TransactionRecordMain> list=transactionRecordMainMapper.queryAll(t);
						PageInfo<TransactionRecordMain> page=new PageInfo<TransactionRecordMain>(list);
						return page;
				}
				
				
				/**
				 * 成交记录分页查询
				 * @param pageNum
				 * @param pageSize
				 * @return
				 */
				public PageInfo<TransactionRecordMain> queryByPage(Integer pageNum){
						PageHelper.startPage(pageNum,6);
						List<TransactionRecordMain> list=transactionRecordMainMapper.queryByPage();
						PageInfo<TransactionRecordMain> page=new PageInfo<TransactionRecordMain>(list);
						return page;
				}
				
				/**
				 * 新增挂单
				 * @param tm
				 * @return
				 */
				public boolean insertAllGd(TransactionRecordMain tm) {
						return transactionRecordMainMapper.insertAllGd(tm)>0;
				}
				
				/**
				 * 查询所有挂单
				 * @return
				 */
				public List<TransactionRecordMain> queryByDd(){
						return transactionRecordMainMapper.queryByDd();
				}
				
				
				/**
				 * 根据订单号删除
				 * @param orderNumber
				 * @return
				 */
				public boolean deleteById(String orderNumber) {
						return transactionRecordMainMapper.deleteById(orderNumber)>0;
				}
				
				/**
				 * 根据订单号查询
				 */
				public TransactionRecordMain queryById(String orderNumber) {
						return transactionRecordMainMapper.queryById(orderNumber);
				}
				
				/**
				 * 根据订单号修改
				 * @param trm
				 * @return
				 */
				public boolean updateByAll(TransactionRecordMain trm) {
						return transactionRecordMainMapper.updateByAll(trm)>0;
				}
}
