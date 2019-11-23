package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CommodityMD;
import com.forest.entity.Images;
import com.forest.entity.ImagesExample;
import com.forest.entity.Size;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.ImagesMapper;
import com.forest.mapper.SizeMapper;
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
	private SizeMapper sizeDAO;
	
	@Autowired
	private ImagesMapper imgDAO;
	
	/**
	 * - 商品管理 - 1.查询全部
	 * @return
	 */
    public PageInfo<CommodityMD> queryMDAllByManager(CommodityMD cmd){
    	PageHelper.startPage(cmd.getPageNum(), 4);
    	List<CommodityMD> comList = cmdDAO.queryMDAllByManager(cmd);
    	PageInfo<CommodityMD> page = new PageInfo<CommodityMD>(comList); 
    	return page;
    }
	
    /**
     * - 商品管理 - 商品上传 - 1.查询全部尺码
     * @return
     */
    public List<Size> querySizeAll(){
    	return sizeDAO.selectByExample(null);
    }
    
    /**
     * - 商品管理 - 商品上传 - 2.图片上传 - 新增图片信息到数据库
     * @param image
     * @return
     */
    public boolean insertImages(Images image) {
    	return imgDAO.insertSelective(image) > 0;
    }
    
    /**
     * - 商品管理 - 商品上传 - 2.图片上传 - 查看新增图片信息
     * @param image
     * @return
     */
    public List<Images> querytImages(String imgPath) {
    	ImagesExample example = new ImagesExample();
    	example.createCriteria().andImgPathLike(imgPath);
    	return imgDAO.selectByExample(example);
    }
    
    
}
