package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CommodityType;
import com.forest.mapper.CommodityTypeMapper;

@Service
@Transactional
public class BcashierBiz {
				@Autowired
				private CommodityTypeMapper commodityTypeMapper;
				
				/**
				 * 收银页面查询前10分类
				 * @return
				 */
				public List<CommodityType> queryBySy(){
					return commodityTypeMapper.queryBySy();
				}
}
