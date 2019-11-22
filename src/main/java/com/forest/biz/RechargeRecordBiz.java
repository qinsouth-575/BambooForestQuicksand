package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.RechargeRecord;
import com.forest.mapper.RechargeRecordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class RechargeRecordBiz {
				@Autowired
				private RechargeRecordMapper rechargeRecordMapper;
				
				/**
				 * 充值抵扣分页查询
				 * @param pageNum
				 * @return
				 */
				public PageInfo<RechargeRecord> queryAll(Integer pageNum){
					PageHelper.startPage(pageNum,6);
					List<RechargeRecord> list=rechargeRecordMapper.queryAll();
					PageInfo<RechargeRecord> page=new PageInfo<RechargeRecord>(list);
					return page;
				}
				
				/**
				 * 新增充值抵扣信息
				 * @param r
				 * @return
				 */
				public boolean insertAll(RechargeRecord r) {
					return rechargeRecordMapper.insertAll(r)>0;
				}
}
