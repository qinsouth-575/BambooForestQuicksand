package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.CommodityMD;
import com.forest.entity.PurchaseMain;
import com.forest.entity.Shop;
import com.forest.mapper.CommodityMDMapper;
import com.forest.mapper.PurchaseMainMapper;
import com.forest.mapper.ShopMapper;
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
}
