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
				
				/**
				 * 新增会员等级
				 * @param ml
				 * @return
				 */
				public boolean insertAll(MemberLevel ml) {
					return memberLevelMapper.insertAll(ml)>0;
				}
				
				
				/**
				 * 根据等级编号查询等级信息
				 * @param mlId
				 * @return
				 */
				public MemberLevel queryById(int mlId) {
					return memberLevelMapper.queryById(mlId);
				}
				
				/**
				 * 根据登记编号修改等级信息
				 * @param ml
				 * @return
				 */
				public boolean updateAll(MemberLevel ml) {
					return memberLevelMapper.updateAll(ml)>0;
				}
}
