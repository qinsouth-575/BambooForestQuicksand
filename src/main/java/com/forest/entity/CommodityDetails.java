package com.forest.entity;

public class CommodityDetails {
    private Integer cdId;

    private Integer cmId;

    private Integer sizeId;

    private Integer colorId;

    private Integer quantity;

    private String barCode;

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

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

	@Override
	public String toString() {
		return "CommodityDetails [cdId=" + cdId + ", cmId=" + cmId + ", sizeId=" + sizeId + ", colorId=" + colorId
				+ ", quantity=" + quantity + ", barCode=" + barCode + "]";
	}
    
}