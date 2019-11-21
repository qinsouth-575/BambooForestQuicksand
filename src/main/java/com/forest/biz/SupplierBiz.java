package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.Supplier;
import com.forest.mapper.SupplierMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SupplierBiz {
	@Autowired
		private SupplierMapper supplierMapper;
		
		/**
		 * 
		 *多条件分页查询所有供应商
		 * 
		 */
		public PageInfo<Supplier> goPage(Supplier sup){
			PageHelper.startPage(sup.pageNum, 3);
			List<Supplier>list=supplierMapper.querySupplier(sup);
			PageInfo<Supplier> page=new PageInfo<Supplier>(list);
			return page;
		}
		/**
		 * 根据Id删除对应的供应商
		 */
		public boolean deleteSupplier(Integer supId) {
			return supplierMapper.deleteByPrimaryKey(supId) > 0;
		}
		/**
		 * 新增供应商
		 */
		public int insertSupplier(Supplier sup) {
			return supplierMapper.insert(sup);
		}
		/**
		 * 根据Id修改对应的供应商
		 */
		public int updateSupplier(Supplier sup) {
			return supplierMapper.updateByPrimaryKey(sup);
		}
		/**
		 * 根据Id查询对应的供应商
		 */
		public Supplier querySupplierId(Integer supId) {
			return supplierMapper.selectByPrimaryKey(supId);
		}
}
