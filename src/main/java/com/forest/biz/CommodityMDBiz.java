package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CommodityMD;
import com.forest.mapper.CommodityMDMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * - 业务逻辑层 - 商品类
 * @author south wind
 * @version v1.0 2019年11月19日 下午3:24:06
 * - 表/功能：
 */
@Service
@Transactional
public class CommodityMDBiz {
	
	@Autowired
	private CommodityMDMapper cmdDAO;
	
	/**
	 * - 1.查询全部
	 * @return
	 */
    public PageInfo<CommodityMD> queryMDAllByManager(Integer pageNum, Integer pageSize){
    	PageHelper.startPage(pageNum, pageSize);
    	List<CommodityMD> comList = cmdDAO.queryMDAllByManager();
    	PageInfo<CommodityMD> page = new PageInfo<CommodityMD>(comList); 
    	return page;
    }
	
}
