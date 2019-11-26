package com.forest.entity;

import java.math.BigDecimal;

public class Member {
    private Integer memberId;

    private Integer phoen;

    private String memberName;

    private Short mlId;

    private String password;

    private String province;

    private String city;

    private String region;

    private String street;

    private BigDecimal balance;

    private Integer integral;

    private String wechatNum;

    private String createTime;
    
    private Integer cs;//会员成交次数
    
    private float je;//会员成交金额
    
    private String ml_name;//会员等级名称
    
    private Integer pageNum;//当前页
    
    public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getMl_name() {
		return ml_name;
	}

	public void setMl_name(String ml_name) {
		this.ml_name = ml_name;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public float getJe() {
		return je;
	}

	public void setJe(float je) {
		this.je = je;
	}

	public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getPhoen() {
        return phoen;
    }

    public void setPhoen(Integer phoen) {
        this.phoen = phoen;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Short getMlId() {
        return mlId;
    }

    public void setMlId(Short mlId) {
        this.mlId = mlId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getWechatNum() {
        return wechatNum;
    }

    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}