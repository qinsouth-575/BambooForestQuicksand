package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.CommodityTypeBiz;
import com.forest.entity.CommodityType;

@Controller
@RequestMapping("commoditytypes")
public class CommodityTypeAction {
	
	private static Logger log = Logger.getLogger(CommodityTypeAction.class);
	
	@Autowired
	private CommodityTypeBiz ctb;
	
	@RequestMapping(value = "toPage", method = RequestMethod.GET)
	public String toD_Commodity() {
		log.debug("BambooForestQuicksand - CommodityTypeAction - toD_Commodity");
		return "d_commodity";
	}
	
	@RequestMapping(value = "ct", method = RequestMethod.GET)
	@ResponseBody
	public List<CommodityType> queryAll(){
		log.debug("BambooForestQuicksand - CommodityTypeAction - queryAll");
		return ctb.queryAll();
	}
	
	@RequestMapping(value = "ct", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> insertCommodityType(CommodityType ct){
		log.debug("BambooForestQuicksand - CommodityTypeAction - insertCommodityType");
		log.info("新增商品类别对象信息为：" + ct);
		Map<String,String> map = new HashMap<String,String>();
		if(ctb.insertCommodityType(ct)) {
			map.put("code", "200");
			map.put("message", "新增成功！");
		} else {
			map.put("code", "500");
			map.put("message", "新增失败！");
		}
		return map;
	}
	
	@RequestMapping(value = "ct", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,String> deleteCommodityType(Integer ctId){
		log.debug("BambooForestQuicksand - CommodityTypeAction - deleteCommodityType");
		log.info("删除条件id为：" + ctId);
		Map<String,String> map = new HashMap<String,String>();
		if(ctb.deleteCommodityType(ctId)) {
			map.put("code", "200");
			map.put("message", "删除成功！");
		} else {
			map.put("code", "500");
			map.put("message", "删除失败！");
		}
		return map;
	}
	
	@RequestMapping(value = "queryCT", method = RequestMethod.GET)
	@ResponseBody
	public CommodityType queryCommodityTypeById(Integer ctId){
		log.debug("BambooForestQuicksand - CommodityTypeAction - queryCommodityTypeById");
		log.info("修改数据的ctId为：" + ctId);
		CommodityType ct = ctb.queryById(ctId);
		log.info("修改商品类别的对象信息为" + ct);
		return ct;
	}
	
	@RequestMapping(value = "ct", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,String> updateCommodityType(CommodityType ct){
		log.debug("BambooForestQuicksand - CommodityTypeAction - updateCommodityType");
		log.info("修改商品类别的对象信息为：" + ct);
		Map<String,String> map = new HashMap<String,String>();
		if(ctb.updateCommodityType(ct)) {
			map.put("code", "200");
			map.put("message", "修改成功！");
		} else {
			map.put("code", "500");
			map.put("message", "修改失败！");
		}
		return map;
	}
	
}
