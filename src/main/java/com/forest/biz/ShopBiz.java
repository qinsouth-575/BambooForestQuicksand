package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.Shop;
import com.forest.mapper.ShopMapper;

@Service
public class ShopBiz {
	@Autowired
		private ShopMapper dao;
		
		public List<Shop> queryAll(){
			return dao.queryAll();
		}
		
		public int insert(Shop shop) {
			return dao.insert(shop);
		}
		
		public Shop queryId(Integer id) {
			return dao.selectByPrimaryKey(id);
		}
		
		public int update(Shop shop) {
			return dao.updateByPrimaryKeySelective(shop);
		}
		
		public int delete(Integer id) {
			return dao.deleteByPrimaryKey(id);
		}
}
