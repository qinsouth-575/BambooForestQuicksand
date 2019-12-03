package com.forest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.BcashierBiz;
import com.forest.biz.CommodityMDBiz;
import com.forest.entity.CommodityMD;
import com.forest.entity.CommodityType;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("Bcashier")
public class BcashierAction {
				
				@Autowired
				private BcashierBiz bcashierBiz;
				
				@Autowired
				private CommodityMDBiz commodityMDBiz;
	
				/**
				 * 进入收银页面
				 * @return
				 */
				@RequestMapping("toBcashier")
				public String toBcashier() {
					return "b_cashier";
				}
				
				/**
				 * 收银页面查询商品类别前10条
				 * @return
				 */
				@RequestMapping("/queryBySy")
				@ResponseBody
				public List<CommodityType> queryBySy(){
					return bcashierBiz.queryBySy();
				}
				
				//商品管理 - 1.商品多条件查询
				@RequestMapping(value = "/queryBySpPage", method = RequestMethod.POST)
				@ResponseBody
				public PageInfo<CommodityMD> queryPage(@RequestBody CommodityMD cmd){
					cmd.setPageSize(15);
					PageInfo<CommodityMD> page = commodityMDBiz.queryMDAllByManager(cmd);
					System.out.println(page);
					return page;
				}
				
				
}
