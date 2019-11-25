package com.forest.entity;

import java.math.BigDecimal;

public class TransactionRecordDetails {
    private Integer trdId;

    private String orderNumber;

    private Integer articleNo;

    private Integer quantity;

    private BigDecimal rawTotalPrice;

    private Float discount;

    private BigDecimal totalPrice;

    private Byte state;
    
    private String createTime;
    
    private String cmName;
    

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCmName() {
		return cmName;
	}

	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	public Integer getTrdId() {
        return trdId;
    }

    public void setTrdId(Integer trdId) {
        this.trdId = trdId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(Integer articleNo) {
        this.articleNo = articleNo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRawTotalPrice() {
        return rawTotalPrice;
    }

    public void setRawTotalPrice(BigDecimal rawTotalPrice) {
        this.rawTotalPrice = rawTotalPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}