package com.forest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.MemberBiz;
import com.forest.entity.Member;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("MemberManage")
public class MemberManageAction {
				@Autowired
				private MemberBiz memberBiz;
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
				/**
				 * 分页查询会员信息
				 * @param pageNum
				 * @return
				 */
				@RequestMapping("/queryAllByPage")
				@ResponseBody
				public PageInfo<Member> queryAllByPage(Integer pageNum){
					System.out.println("当前页数----"+pageNum);
					return memberBiz.queryAllByPage(pageNum);
				}
}
