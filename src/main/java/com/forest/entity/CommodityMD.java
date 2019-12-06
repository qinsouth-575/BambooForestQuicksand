package com.forest.entity;

import java.math.BigDecimal;

/**
 * - 实体层 - 商品主详表查询类
 * @author south wind
 * @version v1.0 2019年11月20日 上午9:22:30
 * - 表/功能：
 */
public class CommodityMD {
	
    private Integer cdId;			//详表id
    private Integer cmId;			//主编号
    private String ctName;			//类别名
    private String cmName;			//商品名
    private String articleNo;		//货号
    private String barCode;			//条码
    private String colorName;		//颜色
    private String sizeName;		//尺码
    private Integer quantity;		//数量
    private BigDecimal salePrice;	//吊牌价
    private BigDecimal costPrice;	//成本价
    private Integer shopId;			//店铺编号
    private Integer ctId;			//类别编号
    private String imgPath;			//图片地址
    
    private Integer pageNum;		//当前页
    private Integer pageSize;		//每页显示条数
    
	public CommodityMD() {
		super();
	}
	
	public CommodityMD(String ctName, Integer shopId, Integer ctId) {
		super();
		this.ctName = ctName;
		this.shopId = shopId;
		this.ctId = ctId;
	}

	public CommodityMD(Integer cdId, Integer cmId, String ctName, String cmName, String articleNo, String barCode,
			String colorName, String sizeName, Integer quantity, BigDecimal salePrice, BigDecimal costPrice,
			Integer shopId, Integer ctId, String imgPath, Integer pageNum, Integer pageSize) {
		super();
		this.cdId = cdId;
		this.cmId = cmId;
		this.ctName = ctName;
		this.cmName = cmName;
		this.articleNo = articleNo;
		this.barCode = barCode;
		this.colorName = colorName;
		this.sizeName = sizeName;
		this.quantity = quantity;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.shopId = shopId;
		this.ctId = ctId;
		this.imgPath = imgPath;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Integer getCdId() {
		return cdId;
	}
	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}
	public Integer getCmId() {
		return cmId;
	}
	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCmName() {
		return cmName;
	}
	public void setCmName(String cmName) {
		this.cmName = cmName;
	}
	public String getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName =colorName;
	}
    public String getSizeName() {
        return sizeName;
    }
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getCtId() {
		return ctId;
	}
	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "CommodityMD [cdId=" + cdId + ", cmId=" + cmId + ", ctName=" + ctName + ", cmName=" + cmName
				+ ", articleNo=" + articleNo + ", barCode=" + barCode + ", colorName=" + colorName + ", sizeName="
				+ sizeName + ", quantity=" + quantity + ", salePrice=" + salePrice + ", costPrice=" + costPrice
				+ ", shopId=" + shopId + ", ctId=" + ctId + ", imgPath=" + imgPath + ", pageNum=" + pageNum
				+ ", pageSize=" + pageSize + "]";
	}
	
}
