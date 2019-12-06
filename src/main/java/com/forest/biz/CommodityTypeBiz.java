package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CommodityType;
import com.forest.entity.CommodityTypeExample;
import com.forest.mapper.CommodityTypeMapper;

@Service
@Transactional
public class CommodityTypeBiz {
	
	@Autowired
	private CommodityTypeMapper ctMapper;
	
	/**
	 * - 1.查询全部商品类别
	 * @return
	 */
	public List<CommodityType> queryAll(){
		return ctMapper.selectByExample(null);
	}
	
	/**
	 * - 2.新增
	 * @param ct
	 * @return
	 */
	public boolean insertCommodityType(CommodityType ct) {
		return ctMapper.insert(ct) > 0;
	}
	
	/**
	 * - 3.删除
	 * @param ctId
	 * @return
	 */
	public boolean deleteCommodityType(Integer ctId) {
		return ctMapper.deleteByPrimaryKey(ctId) > 0;
	}
	
	/**
	 * - 4.1按Id查询
	 * @param ctId
	 * @return
	 */
	public CommodityType queryById(Integer ctId) {
		return ctMapper.selectByPrimaryKey(ctId);
	}
	
	/**
	 * - 4.2修改
	 * @param ct
	 * @return
	 */
	public boolean updateCommodityType(CommodityType ct) {
		return ctMapper.updateByPrimaryKey(ct) > 0;
	}
	
	/**
     * - 5.按类别名查询
     * @param image
     * @return
     */
    public CommodityType querytImages(String ctName) {
    	CommodityTypeExample example = new CommodityTypeExample();
    	example.createCriteria().andCtNameLike(ctName);
    	return ctMapper.selectByExample(example).get(0);
    }
    
}
