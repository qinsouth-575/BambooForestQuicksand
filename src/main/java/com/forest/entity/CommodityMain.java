package com.forest.entity;

import java.math.BigDecimal;
import java.util.List;

public class CommodityMain {
    private Integer cmId;

    private String articleNo;

    private String brand;

    private String cmName;

    private BigDecimal salePrice;

    private BigDecimal costPrice;

    private Integer ctId;

    private String imgPath;

    private String information;

    private Short shopId;
    
    private List<CommodityDetails> cdList;

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Short getShopId() {
        return shopId;
    }

    public void setShopId(Short shopId) {
        this.shopId = shopId;
    }

	public List<CommodityDetails> getCdList() {
		return cdList;
	}

	public void setCdList(List<CommodityDetails> cdList) {
		this.cdList = cdList;
	}

	@Override
	public String toString() {
		return "CommodityMain [cmId=" + cmId + ", articleNo=" + articleNo + ", brand=" + brand + ", cmName=" + cmName
				+ ", salePrice=" + salePrice + ", costPrice=" + costPrice + ", ctId=" + ctId + ", imgPath=" + imgPath
				+ ", information=" + information + ", shopId=" + shopId + ", cdList=" + cdList + "]";
	}
    
}