package com.forest.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * - 控制层 - 库存管理模块
 * @author south wind
 * @version v1.0 2019年12月5日 上午5:26:15
 * - 表/功能：
 */
@Controller
@RequestMapping("inventory")
public class InventoryAction {
	
	private static Logger log = Logger.getLogger(InventoryAction.class); 
	
	//库存管理 - 跳转 库存管理页面
	@RequestMapping(value = "toPage", method = RequestMethod.GET)
	public String toInventoryPage() {
		log.debug("BambooForestQuicksand - InventoryAction - toInventoryPage - 库存管理 - 跳转 库存管理页面");
		return "e_inventory";
	}
	
	
	
}
