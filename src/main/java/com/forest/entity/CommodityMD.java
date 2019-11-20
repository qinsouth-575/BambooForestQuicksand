package com.forest.entity;

import java.math.BigDecimal;

/**
 * - 实体层 - 商品主详表查询类
 * @author south wind
 * @version v1.0 2019年11月20日 上午9:22:30
 * - 表/功能：
 */
public class CommodityMD {
	
    private Integer cdId;
    private Integer cmId;
    private String ctName;
    private String cmName;
    private Integer articleNo;
    private String barCode;
    private Integer color;
    private String sizeName;
    private Integer quantity;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    
    
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
	public Integer getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
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
	
	@Override
	public String toString() {
		return "CommodityMD [cdId=" + cdId + ", cmId=" + cmId + ", ctName=" + ctName + ", cmName=" + cmName
				+ ", articleNo=" + articleNo + ", barCode=" + barCode + ", color=" + color + ", sizeName=" + sizeName
				+ ", quantity=" + quantity + ", salePrice=" + salePrice + ", costPrice=" + costPrice + "]";
	}
    
}
