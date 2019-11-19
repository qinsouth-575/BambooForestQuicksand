package com.forest.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forest.biz.LoginBiz;
import com.forest.entity.Staff;

@Controller
public class LoginAction {
	@Autowired
		private LoginBiz lb;
		
		@RequestMapping("/find")
		public String find() {
			//System.out.println(111);
			return "a_login";
		}
		@RequestMapping("/findshop")
		public String findShop() {
			return "c_shop";
		}
		@RequestMapping("/findstaff")
		public String findStaff() {
			return "c_staff";
		}
		@RequestMapping("/finduser")
		public String findUser() {
			return "c_user";
		}
		@RequestMapping("/findposition")
		public String findPosition() {
			return "c_position-of-authority";
		}
		@RequestMapping("/login")
		public String queryNameAndPwd(Staff staff,HttpSession session) {
			System.out.println(staff.getStaffName());
			System.out.println(staff.getPassword());
			if(lb.queryNameAndPwd(staff)!=null) {
				System.out.println(1111);
				session.setAttribute("account", lb.queryNameAndPwd(staff));
				return "c_user";
			}
			return "a_login";
		}
}
