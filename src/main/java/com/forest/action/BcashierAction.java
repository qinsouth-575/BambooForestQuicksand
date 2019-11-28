package com.forest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.BcashierBiz;
import com.forest.entity.CommodityType;

@Controller
@RequestMapping("Bcashier")
public class BcashierAction {
				
				@Autowired
				private BcashierBiz bcashierBiz;
	
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
				
				
				
}
