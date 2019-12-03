package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.PoBiz;
import com.forest.entity.CommodityMD;
import com.forest.entity.PurchaseMain;
import com.forest.entity.Shop;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/po")
public class PoAction {
	@Autowired
	private PoBiz pb;
	/**
	 * 采购单页面跳转
	 */
	@RequestMapping("toCommodityMD")
	public String toCommodityMD() {
		return "d_commodity_po";
	}
	/**
	 * 新增采购单页面跳转
	 */
	@RequestMapping("toCommodityMDInsert")
	public String toCommodityMDInsert() {
		return "d_commodity_po_insert";
	}
	/**
	 * 查询可添加商品
	 */
	@RequestMapping("queryCommodityMain")
	@ResponseBody
	public PageInfo<CommodityMD> queryCommodityMD(@RequestBody CommodityMD cmd){
		return pb.queryCommodityMD(cmd);
	}
	/**
	 * 查询所有采购单
	 */
	@RequestMapping("queryPurchaseMain")
	@ResponseBody
	public PageInfo<PurchaseMain> queryPurchaseMain(@RequestBody PurchaseMain pm){
		System.out.println(pm.getStartTime());
		System.out.println(pm.getEndTime());
		System.out.println(pm);
		System.out.println(pb.queryPurchaseMain(pm));
		return pb.queryPurchaseMain(pm);
	}
	/**
	 * 查询所有店铺
	 */
	@RequestMapping("queryShop")
	@ResponseBody
	public List<Shop> queryShop(){
		return pb.queryShop();
	}
	/**
	 * 查询单号
	 */
	@RequestMapping("queryCountBill")
	@ResponseBody
	public Map<String,String> queryCountBill(String pmOdd){
		System.out.println(pmOdd);
		Map<String,String> map=new HashMap<String,String>();
		String no=pb.queryCountBill(pmOdd);
		map.put("no", no);
		return map;
	}
	/**
	 * 根据ID查询对应的商品数据
	 */
	@RequestMapping("queryId")
	@ResponseBody
	public CommodityMD queryId(int id) {
		System.out.println(id);
		return pb.queryId(id);
	}
}
