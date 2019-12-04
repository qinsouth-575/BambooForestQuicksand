package com.forest.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.PoBiz;
import com.forest.entity.CommodityMD;
import com.forest.entity.PurchaseMain;
import com.forest.entity.Shop;
import com.forest.entity.Staff;
import com.forest.entity.Supplier;
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
	/**
	 * 取出登录时存的session员工
	 */
	@RequestMapping("querySession")
	@ResponseBody
	public  Staff querySession(HttpSession session) {
		Staff staff=(Staff) session.getAttribute("account");
		return staff;
	}
	/**
	 * 主详新增
	 */
	@RequestMapping("insert")
	@ResponseBody
	public Map<String,String> insert(@RequestBody PurchaseMain pm){
		System.out.println(pm);
		pm.setCreateTime(new Date());
		Map<String,String> map=new HashMap<String,String>();
		if(pb.insert(pm)) {
			map.put("code", "200");
			map.put("message", "新增成功");
		}else {
			map.put("code", "500");
			map.put("message", "新增失败");
		}
		return map;
	}
	/**
	 * 主详修改
	 */
	@RequestMapping("update")
	@ResponseBody
	public Map<String,String> update(@RequestBody PurchaseMain pm){
		System.out.println(pm.getPmId());
		System.out.println(pm.getLister());
		System.out.println(pm.getShopId());
		pm.setCreateTime(new Date());
		Map<String,String> map=new HashMap<String,String>();
		if(pb.update(pm)) {
			map.put("code", "200");
			map.put("message", "修改成功");
		}else {
			map.put("code", "500");
			map.put("message", "修改失败");
		}
		return map;
	}
	/**
	 * 主详删除
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,String> delete(int pmOdd){
		Map<String,String> map=new HashMap<String,String>();
		if(pb.delete(pmOdd)) {
			map.put("code", "200");
			map.put("message", "删除成功");
		}else {
			map.put("code", "500");
			map.put("message", "删除失败");
		}
		return map;
	}
	/**
	 * 根据Id查询渲染数据进行修改
	 */
	@RequestMapping("queryMId")
	@ResponseBody
	public PurchaseMain queryMId(int pmId) {
		return pb.queryMId(pmId);
	}
	/**
	 * 查询所有供应商渲染下拉框
	 */
	@RequestMapping("querySupplier")
	@ResponseBody
	public List<Supplier> querySupplier(){
		return pb.querySupplier();
	}
	/**
	 * 跳转修改页面
	 */
	@RequestMapping("toCommodityMDUpdate")
	public String toCommodityMDUpdate(Integer pmId,Model model) {
		model.addAttribute("pmId", pmId);
		return "d_commodity_po_update";
	}
	/**
	 * 修改状态
	 */
	@RequestMapping("updateStatu")
	@ResponseBody
	public Map<String,String> updateStatu(int id){
		Map<String,String> map=new HashMap<String,String>();
		if(pb.updateStatu(id)) {
			map.put("code", "200");
			map.put("message", "修改成功");
		}else {
			map.put("code", "500");
			map.put("message", "修改失败");
		}
		return map;
	}
}
