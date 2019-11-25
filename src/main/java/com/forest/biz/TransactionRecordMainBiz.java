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
				public PageInfo<TransactionRecordMain> queryAll(Integer pageNum){
						PageHelper.startPage(pageNum,1);
						List<TransactionRecordMain> list=transactionRecordMainMapper.queryAll();
						PageInfo<TransactionRecordMain> page=new PageInfo<TransactionRecordMain>(list);
						return page;
				}
}
