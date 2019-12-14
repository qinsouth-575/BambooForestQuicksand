package com.forest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.PosBiz;
import com.forest.entity.Position;

@Controller
@RequestMapping("pos")
public class PosAction {
	@Autowired
		private PosBiz pb;
		
		/**
		 * 查询所有职位
		 */
		@RequestMapping("/queryAll")
		@ResponseBody
		public List<Position> queryAll(){
			return pb.queryAll();
		}
		/**
		 * 新增职位
		 */
}
