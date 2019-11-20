package com.forest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.MemberLevelBiz;
import com.forest.entity.MemberLevel;

@Controller
@RequestMapping("MemberLevel")
public class MemberLevelAction {
				@Autowired
				private MemberLevelBiz memberLevelBiz;
				
				/**
				 * 查询所有会员等级信息
				 * @return
				 */
				@RequestMapping("/queryAll")
				@ResponseBody
				public List<MemberLevel> queryAll(){
					return memberLevelBiz.queryAll();
				}
}
