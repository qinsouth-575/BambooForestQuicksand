package com.forest.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "cm", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<CommodityMD> queryPage(Integer pageNum){
		log.debug("BambooForestQuicksand - CommodityMDAction - queryAll");
		PageInfo<CommodityMD> page = cmdb.queryMDAllByManager(pageNum, 5);
		log.info("分页类信息：" + page);
		return page;
	}
	
	
	
}
