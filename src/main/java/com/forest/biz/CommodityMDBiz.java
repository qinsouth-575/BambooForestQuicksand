package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CommodityMD;
import com.forest.entity.Images;
import com.forest.entity.ImagesExample;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.ImagesMapper;
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
	
	@Autowired
	private ImagesMapper imgDAO;
	
	/**
	 * - 商品管理 - 1.分页查询商品列表
	 * @return
	 */
    public PageInfo<CommodityMD> queryMDAllByManager(CommodityMD cmd){
    	PageHelper.startPage(cmd.getPageNum(), 4);
    	List<CommodityMD> comList = cmdDAO.queryMDAllByManager(cmd);
    	PageInfo<CommodityMD> page = new PageInfo<CommodityMD>(comList); 
    	return page;
    }
    
    /**
     * - 商品管理 - 商品上传 - 2.商品图片上传 - 新增图片信息到数据库
     * @param image
     * @return
     */
    public boolean insertImages(Images image) {
    	if(this.querytImages(image.getImgPath()).size() <= 0) {
        	//保存商品图片到数据库成功返回true，失败则返回false
        	return imgDAO.insertSelective(image) > 0;
    	}
    	return true;	//已经存在此图片，则不必上传也返回true
    }
    
    /**
     * - 商品管理 - 商品上传 - 2.商品图片上传 - 查看新增图片信息
     * @param image
     * @return
     */
    public List<Images> querytImages(String imgPath) {
    	ImagesExample example = new ImagesExample();
    	example.createCriteria().andImgPathLike(imgPath);
    	return imgDAO.selectByExample(example);
    }
    
    //商品管理 - 商品上传 - 3.颜色管理 - ColorBiz - 一套增删改查
    
    
    
}
