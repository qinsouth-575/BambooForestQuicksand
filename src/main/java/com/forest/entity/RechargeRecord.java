package com.forest.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeRecord {
    private Integer rrId;

    private Integer memberId;

    private BigDecimal rechargeMoney;

    private Integer presentIntegral;

    private Integer rechargeWay;

    private BigDecimal presentBalance;

    private String createTime;

    private String remark;
    
    private String wechatNum;
    
    private String memberName;
    
    private Integer phoen;
    
    private BigDecimal balance;
    
    private float xf;

    public String getWechatNum() {
		return wechatNum;
	}

	public void setWechatNum(String wechatNum) {
		this.wechatNum = wechatNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getPhoen() {
		return phoen;
	}

	public void setPhoen(Integer phoen) {
		this.phoen = phoen;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public float getXf() {
		return xf;
	}

	public void setXf(float xf) {
		this.xf = xf;
	}

	public Integer getRrId() {
        return rrId;
    }

    public void setRrId(Integer rrId) {
        this.rrId = rrId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Integer getPresentIntegral() {
        return presentIntegral;
    }

    public void setPresentIntegral(Integer presentIntegral) {
        this.presentIntegral = presentIntegral;
    }

    public Integer getRechargeWay() {
        return rechargeWay;
    }

    public void setRechargeWay(Integer rechargeWay) {
        this.rechargeWay = rechargeWay;
    }

    public BigDecimal getPresentBalance() {
        return presentBalance;
    }

    public void setPresentBalance(BigDecimal presentBalance) {
        this.presentBalance = presentBalance;
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