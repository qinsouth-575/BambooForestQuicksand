package com.forest.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionRecordMain {
    private Integer trmId;

    private String orderNumber;

    private Integer client;

    private BigDecimal totalSum;

    private Float discount;

    private BigDecimal actualIncome;

    private BigDecimal notIncome;

    private Short paymount;

    private Short shopId;

    private String cashier;

    private String shopAssistant;

    private Byte state;

    private String createTime;

    private String remark;
    
    private String memberNname;
    
    private Integer phoen;
    
    private Integer sl;
    
    private float balance;
    
    private Integer pageNum;//当前页数
    

    public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getMemberNname() {
		return memberNname;
	}

	public void setMemberNname(String memberNname) {
		this.memberNname = memberNname;
	}

	public Integer getPhoen() {
		return phoen;
	}

	public void setPhoen(Integer phoen) {
		this.phoen = phoen;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Integer getTrmId() {
        return trmId;
    }

    public void setTrmId(Integer trmId) {
        this.trmId = trmId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public BigDecimal getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(BigDecimal actualIncome) {
        this.actualIncome = actualIncome;
    }

    public BigDecimal getNotIncome() {
        return notIncome;
    }

    public void setNotIncome(BigDecimal notIncome) {
        this.notIncome = notIncome;
    }

    public Short getPaymount() {
        return paymount;
    }

    public void setPaymount(Short paymount) {
        this.paymount = paymount;
    }

    public Short getShopId() {
        return shopId;
    }

    public void setShopId(Short shopId) {
        this.shopId = shopId;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getShopAssistant() {
        return shopAssistant;
    }

    public void setShopAssistant(String shopAssistant) {
        this.shopAssistant = shopAssistant;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}