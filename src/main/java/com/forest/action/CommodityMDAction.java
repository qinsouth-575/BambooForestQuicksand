package com.forest.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forest.biz.CommodityMDBiz;
import com.forest.entity.CommodityMD;
import com.forest.entity.Images;
import com.forest.entity.Size;
import com.github.pagehelper.PageInfo;

/**
 * - 控制层 - 商品主详表控制类
 * @author south wind
 * @version v1.0 2019年11月20日 上午9:46:29
 * - 表/功能：
 */
@Controller
@RequestMapping("commodityManager")
public class CommodityMDAction {
	
	private static Logger log = Logger.getLogger(CommodityMDAction.class); 
	
	@Autowired
	private CommodityMDBiz cmdb;
	
	//商品管理 - 跳转 商品管理页面
	@RequestMapping(value = "toPage", method = RequestMethod.GET)
	public String toCommodityManagerPage() {
		log.debug("BambooForestQuicksand - CommodityMDAction - toCommodityManagerPage - 商品管理 - 跳转 商品管理页面");
		return "d_commodity_manager";
	}
	
	//商品管理 - 跳转 商品上传页面
	@RequestMapping(value = "toUploadingPage", method = RequestMethod.GET)
	public String toCommodityUploadingPage() {
		log.debug("BambooForestQuicksand - CommodityMDAction - toCommodityUploadingPage - 商品管理 - 跳转 商品上传页面");
		return "d_commodity_uploading";
	}
	
	//商品管理 - 跳转 商品上传编辑页面
	@RequestMapping(value = "toUploadingMainPage", method = RequestMethod.GET)
	public String toCommodityUploadingMainPage() {
		log.debug("BambooForestQuicksand - CommodityMDAction - toCommodityUploadingMainPage - 商品管理 - 跳转 商品上传编辑页面");
		return "uploading_main";
	}
	
	//商品管理 - 1.商品多条件查询
	@RequestMapping(value = "cm", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<CommodityMD> queryPage(@RequestBody CommodityMD cmd){
		log.debug("BambooForestQuicksand - CommodityMDAction - queryPage - 商品管理 - 1.商品多条件查询");
		log.info("多条件+分页查询 - 参数信息：" + cmd);
		PageInfo<CommodityMD> page = cmdb.queryMDAllByManager(cmd);
		log.info("查询结果分页类信息：" + page);
		return page;
	}
	
	//商品管理 - 2.商品上传 - 1.图片上传
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@ResponseBody
	public Images uploadImg(MultipartFile file){
		log.debug("BambooForestQuicksand - CommodityMDAction - uploadImg - 商品管理 - 2.商品上传 - 1.图片上传");
		log.info("上传图片：" + file);
		File directory = new File("/D:/Git/CommodityMainImages");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		try {
			String url = "/D:/Git/CommodityMainImages/";
			url = url+"/"+file.getOriginalFilename();
			File f = new File(url);
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new Images("break");
		}
		
		Images images = new Images(file.getOriginalFilename());
		log.info("新增前：" + images);
		if(cmdb.insertImages(images)) {
			List<Images> imgList = cmdb.querytImages(images.getImgPath());
			log.info("新增后：" + imgList);		//		"/" + file.getOriginalFilename()
			return imgList.get(0);
		}else {
			return new Images("break");
		}
	}
	
	//商品管理 - 2.商品上传 - 2.查询全部商品尺码
	@RequestMapping(value = "querySizeList", method = RequestMethod.GET)
	@ResponseBody
	public List<Size> querySizeAll(){
		log.debug("BambooForestQuicksand - CommodityMDAction - querySizeAll - 商品管理 - 2.商品上传 - 2.查询全部商品尺码");
		return cmdb.querySizeAll();
	}
	
	
	
	
	
	
	
	
}
