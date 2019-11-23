package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.CommodityMD;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.PurchaseDetailsMapper;

@Service
public class PoBiz {
	@Autowired
	private PurchaseDetailsMapper pdmapper;
	@Autowired
	private CommodityMDMapper cmdmapper;
	
		public List<CommodityMD> queryCommodityMD(CommodityMD cmd){
			return cmdmapper.queryMDAllByManager(cmd);
		}
}
