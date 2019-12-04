package com.forest.entity;

import java.math.BigDecimal;

public class PurchaseDetails {
    private Integer pdId;

    private String pmId;

 

	public String getPmId() {
		return pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	private String barCode;

    public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	private Integer quantity;

    private BigDecimal titalDecimal;

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }
	public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTitalDecimal() {
        return titalDecimal;
    }

    public void setTitalDecimal(BigDecimal titalDecimal) {
        this.titalDecimal = titalDecimal;
    }
}