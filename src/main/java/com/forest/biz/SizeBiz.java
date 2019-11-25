package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.Size;
import com.forest.entity.SizeExample;
import com.forest.mapper.SizeMapper;

/**
 * - 业务逻辑层 - 尺码类
 * @author south wind
 * @version v1.0 2019年11月25日 上午7:06:20
 * - 表/功能：
 */
@Service
@Transactional
public class SizeBiz {
	
	@Autowired
	private SizeMapper sizeDAO;
	
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 1.查询全部商品尺码
     * @return
     */
    public List<Size> querySizeAll(){
    	return sizeDAO.selectByExample(null);
    }
	
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 2.新增尺码
     * @param size
     * @return
     */
    public boolean insertSize(Size size) {
    	return sizeDAO.insertSelective(size) > 0;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 3.修改尺码
     * @param size
     * @return
     */
    public boolean updateSize(Size size) {
    	return sizeDAO.updateByPrimaryKeySelective(size) > 0;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 4.删除尺码
     * @param sizeId
     * @return
     */
    public boolean deleteSize(Integer sizeId) {
    	if(sizeDAO.selectSizeIdCount(sizeId) <= 0) {
    		return sizeDAO.deleteByPrimaryKey(sizeId) > 0;
    	}
    	return false;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 5.按ID查询单个尺码
     * @param sizeId
     * @return
     */
    public Size querySizeById(Integer sizeId) {
    	return sizeDAO.selectByPrimaryKey(sizeId);
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 4.尺码管理 - 6.按尺码名称查询
     * @param sizeName
     * @return
     */
    public List<Size> querySizeBySizeName(String sizeName) {
    	SizeExample example = new SizeExample();
    	example.createCriteria().andSizeNameLike(sizeName);
    	return sizeDAO.selectByExample(example);
    }
    
}
