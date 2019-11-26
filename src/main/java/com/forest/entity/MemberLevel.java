package com.forest.entity;

import java.math.BigDecimal;

public class MemberLevel {
    private Short mlId;

    private String mlName;

    private Float discount;

    private Integer upgrade;

    private Integer validity;

    private BigDecimal upgradeRule;
    
    private Integer status;

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Short getMlId() {
        return mlId;
    }

    public void setMlId(Short mlId) {
        this.mlId = mlId;
    }

    public String getMlName() {
        return mlName;
    }

    public void setMlName(String mlName) {
        this.mlName = mlName;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public BigDecimal getUpgradeRule() {
        return upgradeRule;
    }

    public void setUpgradeRule(BigDecimal upgradeRule) {
        this.upgradeRule = upgradeRule;
    }
}