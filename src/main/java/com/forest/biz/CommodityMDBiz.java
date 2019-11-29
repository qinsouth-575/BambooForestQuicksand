package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.CmImgRelation;
import com.forest.entity.CommodityDetails;
import com.forest.entity.CommodityMD;
import com.forest.entity.CommodityMain;
import com.forest.entity.Images;
import com.forest.entity.ImagesExample;
import com.forest.mapper.CmImgRelationMapper;
import com.forest.mapper.CommodityDetailsMapper;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.CommodityMainMapper;
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
	private CommodityMainMapper cmDAO;
	
	@Autowired
	private CommodityDetailsMapper cdDAO;
	
	@Autowired
	private ImagesMapper imgDAO;
	
	@Autowired
	private CmImgRelationMapper cmImgRelationDAO;
	
	/**
	 * - 商品管理 - 1.分页查询商品列表
	 * @return
	 */
    public PageInfo<CommodityMD> queryMDAllByManager(CommodityMD cmd){
    	PageHelper.startPage(cmd.getPageNum(), cmd.getPageSize());
    	List<CommodityMD> comList = cmdDAO.queryMDAllByManager(cmd);
    	PageInfo<CommodityMD> page = new PageInfo<CommodityMD>(comList); 
    	return page;
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 1.商品图片上传 - 新增图片信息到数据库
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
     * - 商品管理 - 2.商品上传 - 1.商品图片上传 - 查看新增图片信息
     * @param image
     * @return
     */
    public List<Images> querytImages(String imgPath) {
    	ImagesExample example = new ImagesExample();
    	example.createCriteria().andImgPathLike(imgPath);
    	return imgDAO.selectByExample(example);
    }
    
    /**
     * - 商品管理 - 2.商品上传 - 2.商品上传
     * @param commodityMain
     */
    public boolean insertCommodityMainAndDetail(CommodityMain commodityMain) {
    	if(cmDAO.insertSelective(commodityMain) > 0) {
			Integer cmId = cmDAO.selectCommodityMainMax();
			
    		List<CommodityDetails> cdList = commodityMain.getCdList();
    		boolean flag = true;
    		for (int i = 0; i < cdList.size(); i++) {
    			cdList.get(i).setCmId(cmId);	//录入商品详表主键值
				if(cdDAO.insertSelective(cdList.get(i)) <= 0) {
					flag = false;
				}
			}

    		if(flag) {
    			boolean scon = true;
    			
        		List<Images> imgList = commodityMain.getImgList();
    			for (int i = 0; i < imgList.size(); i++) {
    				CmImgRelation cmImgRelation = new CmImgRelation();
    				if(i == 0) {
    					cmImgRelation = new CmImgRelation(cmId, imgList.get(i).getImgId(), 1);
    				} else {
    					cmImgRelation = new CmImgRelation(cmId, imgList.get(i).getImgId(), 0);
    				}
    				
    				if(cmImgRelationDAO.insertSelective(cmImgRelation) <= 0) {
    					scon = false;
    				}
				}
    			
    			return scon;
    		}
    	}
    	
    	return false;
    }
    
    //商品管理 - 2.商品上传 - 3.颜色管理 - ColorBiz - 一套增删改查
    
    //商品管理 - 2.商品上传 - 4.尺码管理 - SizeBiz - 一套增删改查
    
    /**
     * - 商品管理 - 3.1商品修改 查询商品
     * @param commodityMain
     */
    public CommodityMain queryCommodityMainById(Integer cmId) {
    	List<Images> imgList = imgDAO.selectImagesList(cmId);
    	List<CommodityDetails> cdList = cdDAO.selectCommodityDetailsList(cmId);
    	CommodityMain commodityMain = cmDAO.selectByPrimaryKey(cmId);
    	commodityMain.setCdList(cdList);
    	commodityMain.setImgList(imgList);
    	return commodityMain;
    }
    
    /**
     * -  商品管理 - 3.2商品修改 修改商品
     * @param commodityMain
     * @return
     */
    public boolean updateCommodityMainAndDetail (CommodityMain commodityMain) {
    	if(cmImgRelationDAO.deleteCmImgRelationByCmId(commodityMain.getCmId()) > 0 && cdDAO.deleteCommodityDetailsByCmId(commodityMain.getCmId()) > 0) {
    		if(cmDAO.updateByPrimaryKeySelective(commodityMain) > 0) {
    			Integer cmId = cmDAO.selectCommodityMainMax();
    			
    			List<CommodityDetails> cdList = commodityMain.getCdList();
        		boolean flag = true;
        		for (int i = 0; i < cdList.size(); i++) {
    				if(cdDAO.insertSelective(cdList.get(i)) <= 0) {
    					flag = false;
    				}
    			}

        		if(flag) {
        			boolean scon = true;
        			
            		List<Images> imgList = commodityMain.getImgList();
        			for (int i = 0; i < imgList.size(); i++) {
        				CmImgRelation cmImgRelation = new CmImgRelation();
        				if(i == 0) {
        					cmImgRelation = new CmImgRelation(cmId, imgList.get(i).getImgId(), 1);
        				} else {
        					cmImgRelation = new CmImgRelation(cmId, imgList.get(i).getImgId(), 0);
        				}
        				
        				if(cmImgRelationDAO.insertSelective(cmImgRelation) <= 0) {
        					scon = false;
        				}
    				}
        			
        			return scon;
        		}
    		}
    	}
    	return false;
    }
    
    /**
     * - 商品管理 - 4.删除商品
     * @param cmId
     * @return
     */
    public boolean deleteCommodityMainAndDetail (Integer cdId) {
		Integer cmId = cdDAO.selectByPrimaryKey(cdId).getCmId();
    	
    	if(cdDAO.deleteByPrimaryKey(cdId) > 0) {
    		if(cdDAO.selectCommodityMainCount(cdId) <= 0) {
    			//当删除商品的主表数据没有详表数据时，才能将主表的数据删除！
    			cmDAO.deleteByPrimaryKey(cmId);
    		}
    	}
    	return false;
    }
    
    //尚未继续开发
    
}
