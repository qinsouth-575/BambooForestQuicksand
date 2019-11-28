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

import com.forest.biz.ColorBiz;
import com.forest.biz.CommodityMDBiz;
import com.forest.biz.SizeBiz;
import com.forest.entity.Color;
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
	
	@Autowired
	private ColorBiz cb;
	
	@Autowired
	private SizeBiz sb;
	
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
		cmd.setPageSize(4);
		PageInfo<CommodityMD> page = cmdb.queryMDAllByManager(cmd);
		log.info("查询结果分页类信息：" + page);
		return page;
	}
	
	//商品管理 - 2.商品上传 - 1.商品图片上传
	@RequestMapping(value = "/uploadingCommodityImg", method = RequestMethod.POST)
	@ResponseBody
	public Images uploadingCommodityImg(MultipartFile file){
		log.debug("BambooForestQuicksand - CommodityMDAction - uploadingCommodityImg - 商品管理 - 2.商品上传 - 1.商品图片上传");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//商品管理 - 2.商品上传 - 2.查询全部商品类别
	
	//商品管理 - 2.商品上传 - 3.颜色管理 - 1.新增颜色信息到数据库 OR 2.修改颜色名称
	@RequestMapping(value = "insertOrUpdateColorName", method = RequestMethod.POST)
	@ResponseBody
	public Color insertOrUpdateColorName(@RequestBody Color color){
		log.debug("BambooForestQuicksand - CommodityMDAction - insertOrUpdateColorName - 商品管理 - 2.商品上传 - 3.颜色管理 - 1.新增颜色信息到数据库 OR 2.修改颜色名称");
		log.info("颜色信息：" + color);
		//点击颜色列表或新增颜色，都会获得焦点，则必然触发本事件
		//空 新名字 颜色列表有 		修改的新名字
		
		if(color.getColorName().equals(""))
			return new Color(500, "颜色名不能为空！");
		
		//新增		id为0						空名字查询结果集合的长度为0
		if(color.getColorId() == 0) {
			List<Color> colorList = cb.queryColors(color.getColorName());
			log.info(colorList + " \n集合长度为： " + colorList.size());
			if(colorList.size() >= 1) {
				return colorList.get(0);
			} else {
				if (cb.insertColor(color)) 
					return cb.queryColors(color.getColorName()).get(0);
			}
		} else {	//修改
			if (cb.updateColorName(color))
				return cb.queryColorById(color.getColorId());
		}
		
		return new Color(500, " 新增/修改 失败！");
	}

	//商品管理 - 2.商品上传 - 3.颜色管理 - 3.修改颜色图片路径
	@RequestMapping(value = "/uploadingColorImg", method = RequestMethod.POST)
	@ResponseBody
	public Color uploadingColorImg(MultipartFile file, Integer colorId){
		log.debug("BambooForestQuicksand - CommodityMDAction - uploadingColorImg - 商品管理 - 2.商品上传 - 3.颜色管理 - 3.修改颜色图片路径");
		log.info("上传颜色图片：" + file + "\t" + colorId);
		File directory = new File("/D:/Git/ColorImages");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		try {
			String url = "/D:/Git/ColorImages/";
			url = url+"/"+file.getOriginalFilename();
			File f = new File(url);
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new Color(500, "修改失败！");
		}
		
		Color color = new Color(colorId);
		color.setColorPrcture(file.getOriginalFilename());
		log.info("修改颜色图片路径前：" + color);
		if(cb.updateColorImgPath(color)) {
			color = cb.queryColorById(colorId);
			log.info("修改颜色图片路径后：" + color);	// "/" + file.getOriginalFilename()
			return color;
		}else {
			return new Color(500, "修改失败！");
		}
	}
	
	//商品管理 - 2.商品上传 - 3.颜色管理 - 4.删除颜色
	@RequestMapping(value = "/deleteColor", method = RequestMethod.POST)
	@ResponseBody
	public Color deleteColor(Integer colorId) {
		log.debug("BambooForestQuicksand - CommodityMDAction - deleteColor - 商品管理 - 2.商品上传 - 3.颜色管理 - 4.删除颜色");
		log.info("删除颜色编号：" + colorId);
		if(colorId <= 32)
			return new Color(200, "成功，because不必删除！");
		
		if(cb.deleteColor(colorId)) {
			return new Color(200, "删除成功！");
		}
		return new Color(500, "删除失败！");
	}
	
	/////////////////////////////////////////////////////////////////////
	
	//商品管理 - 2.商品上传 - 4.尺码管理 - 1.查询全部商品尺码
	@RequestMapping(value = "querySizeList", method = RequestMethod.GET)
	@ResponseBody
	public List<Size> querySizeAll(){
		log.debug("BambooForestQuicksand - CommodityMDAction - querySizeAll - 商品管理 - 2.商品上传 - 4.尺码管理 - 1.查询全部商品尺码");
		return sb.querySizeAll();
	}

	//商品管理 - 2.商品上传 - 4.尺码管理 - 2.新增尺码 or 3.修改尺码
	@RequestMapping(value = "insertOrUpdateSize", method = RequestMethod.POST)
	@ResponseBody
	public Size insertOrUpdateSize(@RequestBody Size size) {
		log.debug("BambooForestQuicksand - CommodityMDAction - insertSize - 商品管理 - 2.商品上传 - 4.尺码管理 - 2.新增尺码 or 3.修改尺码");
		log.info("尺码对象数据：" + size);

		if("".equals(size.getSizeName()))
			return new Size(500, "尺码名不能为空！");
		
		//新增		id为0						空名字查询结果集合的长度为0
		if(size.getSizeId() == 0) {
			List<Size> sizeList = sb.querySizeBySizeName(size.getSizeName());
			log.info(sizeList + "\t集合长度为： " + sizeList.size());
			if(sizeList.size() >= 1) {
				return new Size(501, "尺码已存在，新增失败！");
			} else {
				if (sb.insertSize(size)) 
					return sb.querySizeBySizeName(size.getSizeName()).get(0);
			}
		} else {	//修改
			if (sb.updateSize(size))
				return sb.querySizeById(size.getSizeId());
		}
		return new Size(500, " 新增/修改 失败！");
	}

	//商品管理 - 2.商品上传 - 4.尺码管理 - 4.删除尺码
	@RequestMapping(value = "deleteSize", method = RequestMethod.DELETE)
	@ResponseBody
	public Size deleteSize(Integer sizeId) {
		log.debug("BambooForestQuicksand - CommodityMDAction - deleteSize - 商品管理 - 2.商品上传 - 4.尺码管理 - 4.删除尺码");
		log.info("尺码编号数据：" + sizeId);
		if(sb.deleteSize(sizeId)) {
			return new Size(200, "删除成功！");
		}
		return new Size(500, "该尺码已被引用，删除失败！");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//商品管理 - 3.修改商品 - 2.查看自定义新增的颜色列表
	
	
	
	
	
}
