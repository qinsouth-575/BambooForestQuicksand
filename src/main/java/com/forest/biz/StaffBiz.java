package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.Position;
import com.forest.entity.Shop;
import com.forest.entity.Staff;
import com.forest.mapper.PositionMapper;
import com.forest.mapper.ShopMapper;
import com.forest.mapper.StaffMapper;

@Service
public class StaffBiz {
	@Autowired
		private StaffMapper dao;
	@Autowired
		private ShopMapper shop;
	@Autowired
		private PositionMapper pos;
		public List<Staff> queryAll(){
			return dao.queryAll();
		}
		
		public Staff queryId(Integer id) {
			return dao.selectByPrimaryKey(id);
		}
		
		public List<Shop> queryShop() {
			return shop.selectByExample(null);
		}
		
		public List<Position> queryStaff() {
			return pos.selectByExample(null);
		}
		
		public int delete(Integer id) {
			return dao.deleteByPrimaryKey(id);
		}
		public int insert(Staff staff) {
			return dao.insert(staff);
		}
		public int update(Staff staff) {
			return dao.updateByPrimaryKeySelective(staff);
		}
		public List<Staff> queryShopAndPos(Staff staff){
			return dao.queryShopIdAndPosId(staff);
		}
		public int updateStaff(Staff staff) {
			return dao.updateStaff(staff);
		}
		
}
