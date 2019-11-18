package com.forest.entity;

import java.math.BigDecimal;

public class PurchaseDetails {
    private Integer pdId;

    private Integer pmId;

    private Integer articleNo;

    private Integer quantity;

    private BigDecimal titalDecimal;

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
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

    public BigDecimal getTitalDecimal() {
        return titalDecimal;
    }

    public void setTitalDecimal(BigDecimal titalDecimal) {
        this.titalDecimal = titalDecimal;
    }
}