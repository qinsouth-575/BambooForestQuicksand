package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.MemberLevel;
import com.forest.mapper.MemberLevelMapper;

@Service
@Transactional
public class MemberLevelBiz {
				@Autowired
				private MemberLevelMapper memberLevelMapper;
				
				/**
				 * 查询所有等级信息
				 * @return
				 */
				public List<MemberLevel> queryAll(){
						return memberLevelMapper.queryAll();
				}
}
