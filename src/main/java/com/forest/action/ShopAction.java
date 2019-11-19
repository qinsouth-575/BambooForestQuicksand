package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.ShopBiz;
import com.forest.entity.Shop;

@Controller
public class ShopAction {
	@Autowired
		private ShopBiz sb;
		
		@RequestMapping("/queryAll")
		@ResponseBody
		public List<Shop> queryAll(){
			System.out.println(sb.queryAll());
			return sb.queryAll();
		}
		@RequestMapping("/insert")
		@ResponseBody
		public Map<String,String> insert(Shop shop){
			System.out.println(shop);
			sb.insert(shop);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "新增成功");
			return map;
		}
		@RequestMapping("/queryId")
		@ResponseBody
		public Shop queryId(Integer id) {
			System.out.println(sb.queryId(id).getLinkman());
			return sb.queryId(id);
		}
		@PostMapping("/update")
		@ResponseBody
		public Map<String,String> update(@RequestBody Shop shop){
			System.out.println(shop.getAccount());
			System.out.println(shop.getStreet());
			sb.update(shop);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "修改成功");
			return map;
		}
		@PostMapping("/delete")
		@ResponseBody
		public Map<String,String> delete(Integer id){
			System.out.println(id);
			sb.delete(id);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "删除成功");
			return map;
		}
}
