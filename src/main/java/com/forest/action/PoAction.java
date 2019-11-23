package com.forest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.PoBiz;
import com.forest.entity.CommodityMD;

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
	@RequestMapping
	@ResponseBody
	public List<CommodityMD> queryCommodityMD(CommodityMD cmd){
		return pb.queryCommodityMD(cmd);
	}
}
