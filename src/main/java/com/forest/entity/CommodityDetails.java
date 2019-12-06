package com.forest.entity;

public class CommodityDetails {
	
    private Integer cdId;

    private Integer cmId;

    private Integer sizeId;

    private String sizeName;

    private Integer colorId;

    private String colorName;

    private String colorPrcture;

    private Integer quantity;

    private String barCode;

    public CommodityDetails() {
		super();
	}

	public CommodityDetails(Integer sizeId, String sizeName, Integer colorId, String colorName, Integer quantity,
			String barCode) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.colorId = colorId;
		this.colorName = colorName;
		this.quantity = quantity;
		this.barCode = barCode;
	}

	public CommodityDetails(Integer cdId, Integer cmId, Integer sizeId, String sizeName, Integer colorId,
			String colorName, String colorPrcture, Integer quantity, String barCode) {
		super();
		this.cdId = cdId;
		this.cmId = cmId;
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.colorId = colorId;
		this.colorName = colorName;
		this.colorPrcture = colorPrcture;
		this.quantity = quantity;
		this.barCode = barCode;
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

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    
    public String getColorPrcture() {
        return colorPrcture;
    }

    public void setColorPrcture(String colorPrcture) {
        this.colorPrcture = colorPrcture;
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
		return "CommodityDetails [cdId=" + cdId + ", cmId=" + cmId + ", sizeId=" + sizeId + ", sizeName=" + sizeName
				+ ", colorId=" + colorId + ", colorName=" + colorName + ", colorPrcture=" + colorPrcture + ", quantity="
				+ quantity + ", barCode=" + barCode + "]";
	}
    
}