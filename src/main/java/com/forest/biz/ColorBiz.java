package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.Color;
import com.forest.entity.ColorExample;
import com.forest.mapper.ColorMapper;

/**
 * - 业务逻辑层 - 颜色类
 * @author south wind
 * @version v1.0 2019年11月25日 上午2:36:11
 * - 表/功能：
 */
@Service
@Transactional
public class ColorBiz {
	
	@Autowired
	private ColorMapper colorDAO;
    
    /**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 1.按name查看 新增/修改 颜色信息
     * @param colorName
     * @return
     */
    public List<Color> queryColors(String colorName){
    	ColorExample example = new ColorExample();
    	example.createCriteria().andColorNameLike(colorName);
    	return colorDAO.selectByExample(example);
    }
	
	/**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 2.新增颜色信息到数据库
     * @param color
     * @return
     */
    public boolean insertColor(Color color) {
    	//保存颜色图片到数据库成功返回true，失败则返回false
    	return colorDAO.insertSelective(color) > 0;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 3.修改颜色名称
     * @param color
     * @return
     */
    public boolean updateColorName(Color color) {
    	//修改颜色信息到数据库成功返回true，失败则返回false
    	return colorDAO.updateByPrimaryKeySelective(color) > 0;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 4.按id查看新增颜色信息
     * @param colorName
     * @return
     */
    public Color queryColorById(Integer colorId){
    	return colorDAO.selectByPrimaryKey(colorId);
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 5.修改颜色图片路径
     * @param color
     * @return
     */
    public boolean updateColorImgPath(Color color) {
    	return colorDAO.updateByPrimaryKeySelective(color) > 0;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 3.颜色管理 - 6.删除颜色信息
     * @param colorId
     * @return
     */
    public boolean deleteColor(Integer colorId) {
    	return colorDAO.deleteByPrimaryKey(colorId) > 0;
    }
	
}
