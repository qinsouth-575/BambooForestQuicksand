package com.forest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.forest.biz.StaffBiz;
import com.forest.entity.Position;
import com.forest.entity.Shop;
import com.forest.entity.Staff;

@Controller
public class StaffAction {
	@Autowired
		private StaffBiz sb;
		
		@RequestMapping("/query")
		@ResponseBody
		public List<Staff> queryAll(){
			return sb.queryAll();
		}
		@GetMapping("/querySandP")
		@ResponseBody
		public List<Staff> querySandP(Short shopId,Integer posId,String jobNumber){
			Staff staff=new Staff();
			staff.setJobNumber(jobNumber);
			staff.setPosId(posId);
			staff.setShopId(shopId);
			System.out.println(staff);
			return sb.queryShopAndPos(staff);
		}
		@RequestMapping("/queryPos")
		@ResponseBody
		public List<Position> queryPos(){
			return sb.queryStaff();
		}
		@RequestMapping("/queryShop")
		@ResponseBody
		public List<Shop> queryShop(){
			System.out.println(sb.queryShop());
			return sb.queryShop();
		}
		@RequestMapping("/queryStaffId")
		@ResponseBody
		public Staff queryId(Integer id) {
			Staff staff = sb.queryId(id);
			System.out.println(JSON.toJSONString(staff));
			return staff;
		}
		@PostMapping("/deleteStaffId")
		@ResponseBody
		public Map<String,String> delete(Integer id){
			System.out.println(id);
			System.out.println(sb.delete(id));
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "删除成功");
			return map;
		}
		@PostMapping("/insertStaff")
		@ResponseBody
		public Map<String,String> insert(@RequestBody Staff staff){
			System.out.println(staff);
			sb.insert(staff);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "新增成功");
			return map;
		}
		@PostMapping("/updateStaff")
		@ResponseBody
		public Map<String,String> update(@RequestBody Staff staff){
			System.out.println(staff);
			sb.update(staff);
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "修改成功");
			return map;
		}
		@RequestMapping("/session")
		@ResponseBody
		public Staff StaffSession(HttpSession session) {
			Staff staff=(Staff) session.getAttribute("account");
			return staff;
		}
		@RequestMapping("/updateUser")
		@ResponseBody
		public Map<String,String> updateUser(@RequestBody Staff staff){
			System.out.println(staff);
			System.out.println(sb.updateStaff(staff));
			Map<String,String> map=new HashMap<String, String>();
			map.put("code", "修改成功");
			return map;
		}
		
}
