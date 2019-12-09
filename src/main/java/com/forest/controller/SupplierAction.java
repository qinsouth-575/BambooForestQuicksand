package com.forest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.SupplierBiz;
import com.forest.entity.Supplier;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("supplier")
public class SupplierAction {
	@Autowired
	private SupplierBiz sb;
		@RequestMapping("/toSupplier")
		public String toSupplier() {
			return "d_commodity_supplier";
		}
		
		/**
		 *多条件:省份、城市、模糊查公司名称。分页查询所有供应商
		 */
		@RequestMapping("/goPage")
		@ResponseBody
		public PageInfo<Supplier> goPage(@RequestBody Supplier sup){
			System.out.println(sup);
			return sb.goPage(sup);
		}
		/**
		 * 新增供应商
		 */
		@RequestMapping("/insertSupplier")
		@ResponseBody
		public Map<String,String> insertSupplier(Supplier sup){
			sb.insertSupplier(sup);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "新增成功");
			return map;
		}
		/**
		 * 删除供应商
		 */
		@RequestMapping("/deleteSupplier")
		@ResponseBody
		public Map<String,String> deleteSupplier(Integer id){
			Map<String,String> map=new HashMap<String, String>();
			try {
				if(sb.deleteSupplier(id)) {
					map.put("code", "200");
					map.put("message", "删除成功！");
					return map;
				}
				map.put("code", "500");
				map.put("message", "删除失败！");
			} catch (Exception e) {
				// TODO: handle exception
				map.put("code", "500");
				map.put("message", "删除失败！");
			}
			return map;
		}
		/**
		 * 修改供应商
		 */
		@RequestMapping("/updateSupplier")
		@ResponseBody
		public Map<String,String> updateSupplier(@RequestBody Supplier sup){
			sb.updateSupplier(sup);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "修改成功");
			return map;
		}
		/**
		 * 根据Id查询供应商
		 */
		@RequestMapping("/querySupplier")
		@ResponseBody
		public Supplier querySupplier(Integer supId) {
			System.out.println(supId);
			System.out.println(sb.querySupplierId(supId));
			return sb.querySupplierId(supId);
		}
}
