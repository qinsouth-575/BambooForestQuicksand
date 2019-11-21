package com.forest.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.CommodityMDBiz;
import com.forest.entity.CommodityMD;
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
	
	@RequestMapping(value = "toPage", method = RequestMethod.GET)
	public String toCommodityManager() {
		log.debug("BambooForestQuicksand - CommodityMDAction - toCommodityManager");
		return "d_commodity_manager";
	}
	
	@RequestMapping(value = "cm", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<CommodityMD> queryPage(@RequestBody CommodityMD cmd){
		log.debug("BambooForestQuicksand - CommodityMDAction - queryPage");
		log.info("多条件+分页查询 - 参数信息：" + cmd);
		PageInfo<CommodityMD> page = cmdb.queryMDAllByManager(cmd);
		log.info("查询结果分页类信息：" + page);
		return page;
	}
	
	
	
	
	
	
	@RequestMapping(value = "toUploading", method = RequestMethod.GET)
	public String toCommodityUploading() {
		log.debug("BambooForestQuicksand - CommodityMDAction - toCommodityUploading");
		
		return "d_commodity_uploading";
	}
	
	
	
}
