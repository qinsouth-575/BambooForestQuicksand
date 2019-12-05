package com.forest.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * - 控制层 - 统计报表模块
 * @author south wind
 * @version v1.0 2019年12月5日 上午4:59:02
 * - 表/功能：
 */
@Controller
@RequestMapping("statistics")
public class StatisticsAction {
	
	private static Logger log = Logger.getLogger(StatisticsAction.class); 

	//统计报表 - 跳转 统计报表管理页面
	@RequestMapping(value = "toPage", method = RequestMethod.GET)
	public String toStatistics() {
		log.debug("BambooForestQuicksand - StatisticsAction - toStatistics - 统计报表 - 跳转统计页面");
		return "a_statistics";
	}
	
	
}
