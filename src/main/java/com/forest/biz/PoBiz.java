package com.forest.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.CommodityMD;
import com.forest.entity.PurchaseDetails;
import com.forest.entity.PurchaseMain;
import com.forest.entity.Shop;
import com.forest.entity.Supplier;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.PurchaseDetailsMapper;
import com.forest.mapper.PurchaseMainMapper;
import com.forest.mapper.ShopMapper;
import com.forest.mapper.SupplierMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PoBiz {
	@Autowired
	private PurchaseMainMapper pdmapper;
	@Autowired
	private CommodityMDMapper cmdmapper;
	@Autowired
	private ShopMapper shopMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private PurchaseDetailsMapper pdsmapper;
		/**
		 * 查询可添加商品
		 * @param cmd
		 * @return
		 */
		public PageInfo<CommodityMD> queryCommodityMD(CommodityMD cmd){
	
			PageHelper.startPage(cmd.getPageNum(), 5);
			List<CommodityMD> list=cmdmapper.queryMDAllByManager(cmd);
			PageInfo<CommodityMD> page=new PageInfo<CommodityMD>(list);
			return page;
		}
		/**
		 * 分页查询
		 * @param pm
		 * @return
		 */
		public PageInfo<PurchaseMain> queryPurchaseMain(PurchaseMain pm){
			PageHelper.startPage(pm.getPageNum(), 3);
			List<PurchaseMain> list=pdmapper.queryAll(pm);
			PageInfo<PurchaseMain> page=new PageInfo<>(list);
			return page;
		}
		/**
		 * 查询所有店铺
		 * @return
		 */
		public List<Shop> queryShop(){
			return shopMapper.selectByExample(null);
		}
		/**
		 * 查询采购单号是否存在数据库 如果存在则在原有的基础上加一
		 */
		public String queryCountBill(String pmOdd){
			int count=pdmapper.queryCountBill(pmOdd+"%")+1;
			String billno_=pmOdd;
			if(count<=9){
				billno_+="00"+count;
			}else{
				billno_+="0"+count;
			}
			return billno_;
			
		}
		/**
		 * 添加数据
		 */
		public CommodityMD queryId(int id) {
			return pdmapper.queryId(id);
		}
		/**
		 * 主详新增
		 */
		public boolean insert(PurchaseMain pm) {
			if(pm.getList()==null) {
				return false;
			}else {
				pdmapper.insertD(pm.getList());
				pdmapper.insertM(pm);
			}
			
			return true;
		}
		/**
		 * 主详修改
		 */
		public boolean update(PurchaseMain pm) {
			if(pdmapper.updateM(pm)>0) {
				System.out.println(11111);
				pdmapper.deleteD(pm.getPmOdd());
				System.out.println(22222);
				pdmapper.insertD(pm.getList());
				return true;
			}
				return false;
		}
		/**
		 * 主详删除
		 */
		public boolean delete(int pmOdd) {
			if(pmOdd!=0) {
				pdmapper.deleteMD(pmOdd);
				pdmapper.deleteM(pmOdd);
				return true;
			}
			return false;
		}
		/**
		 * 根据ID查询渲染数据
		 */
		public PurchaseMain queryMId(int pm_id) {
			PurchaseMain p = new PurchaseMain();
			p = pdmapper.queryMId(pm_id);
			p.setList(pdsmapper.queryDId(p.getPmOdd()));
			return p;
		}
		/**
		 * 查询所有供应商
		 */
		public List<Supplier> querySupplier(){
			return supplierMapper.selectByExample(null);
		}
		/**
		 * 修改状态
		 */
		public boolean updateStatu(int pm) {
			if(pdmapper.updateStatu(pm)>0) {
				return true;
			}
			return false;
		}
}
