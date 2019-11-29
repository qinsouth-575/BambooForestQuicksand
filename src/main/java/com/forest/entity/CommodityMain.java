package com.forest.entity;

import java.math.BigDecimal;
import java.util.List;

public class CommodityMain {
    private Integer cmId;
    private String articleNo;		//商品货号
    private String brand;			//商品品牌
    private String cmName;			//商品名称
    private BigDecimal salePrice;	//吊牌价格
    private BigDecimal costPrice;	//成本价格
    private Integer ctId;			//商品类别编号
    private String information;		//商品信息
    private Short shopId;			//店铺编号（外键）
    
    private List<CommodityDetails> cdList;	//详表数据
    private List<Images> imgList;	//图片集合

    public CommodityMain() {
		super();
	}

	public CommodityMain(Integer cmId, String cmName) {
		super();
		this.cmId = cmId;
		this.cmName = cmName;
	}

	public CommodityMain(Integer cmId, String articleNo, String brand, String cmName, BigDecimal salePrice,
			BigDecimal costPrice, Integer ctId, String information, Short shopId, List<CommodityDetails> cdList,
			List<Images> imgList) {
		super();
		this.cmId = cmId;
		this.articleNo = articleNo;
		this.brand = brand;
		this.cmName = cmName;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.ctId = ctId;
		this.information = information;
		this.shopId = shopId;
		this.cdList = cdList;
		this.imgList = imgList;
	}

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

	public List<Images> getImgList() {
		return imgList;
	}

	public void setImgList(List<Images> imgList) {
		this.imgList = imgList;
	}

	@Override
	public String toString() {
		return "CommodityMain [cmId=" + cmId + ", articleNo=" + articleNo + ", brand=" + brand + ", cmName=" + cmName
				+ ", salePrice=" + salePrice + ", costPrice=" + costPrice + ", ctId=" + ctId + ", information="
				+ information + ", shopId=" + shopId + ", cdList=" + cdList + ", imgList=" + imgList + "]";
	}
    
}