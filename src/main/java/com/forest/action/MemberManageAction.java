package com.forest.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("MemberManage")
public class MemberManageAction {
				/**
				 * 进入会员主页面
				 * @return
				 */
				@RequestMapping("/toMember")
				public String toMember() {
					return "f_member";
				}
				/**
				 * 进入会员充值抵扣页面
				 * @return
				 */
				@RequestMapping("/toRecharge")
				public String toRecharge() {
					return "f_member_recharge";
				}
				
				/**
				 * 进入会员成交记录页面
				 * @return
				 */
				@RequestMapping("/toMake")
				public String toMake() {
					return "f_member_make";
				}
				
				/**
				 * 进入会员等级页面
				 * @return
				 */
				@RequestMapping("/toLevel")
				public String toLevel() {
					System.out.println("进入等级页面");
					return "f_member_level";
				}
				
				/**
				 * 进入会员积分设置页面
				 * @return
				 */
				@RequestMapping("/toCredits")
				public String toCredits() {
					return "f_member_credits";
				}
}
