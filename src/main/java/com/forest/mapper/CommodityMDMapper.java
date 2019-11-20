package com.forest.mapper;

import java.util.List;

import com.forest.entity.CommodityMD;

/**
 * - 数据访问层 - 商品主详标DAO接口类
 * @author south wind
 * @version v1.0 2019年11月20日 上午9:25:16
 * - 表/功能：
 */
public interface CommodityMDMapper {

	/**
	 * - 1.查询全部
	 * @return
	 */
    public List<CommodityMD> queryMDAllByManager();
}
