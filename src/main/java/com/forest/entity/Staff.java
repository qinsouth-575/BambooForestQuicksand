package com.forest.entity;

import java.util.Date;

public class Staff {
    private Integer staffId;

    private Short shopId;

    private Integer posId;

    private String jobNumber;

    private String staffName;

    private String password;

    private Integer staffState;

    private Date createTime;

    private String trade;

    private String headPortraitPath;

    private String phone;
    
    private String shopName;
    
    private String posName;
	
	private String randomCode;	//随机数验证码 - 11

    private String salt;
    
	public Staff() {
		super();
	}

	public Staff(Integer staffId) {
		super();
		this.staffId = staffId;
	}

	public Staff(Integer staffId, String headPortraitPath) {
		super();
		this.staffId = staffId;
		this.headPortraitPath = headPortraitPath;
	}

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Short getShopId() {
        return shopId;
    }

    public void setShopId(Short shopId) {
        this.shopId = shopId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStaffState() {
        return staffState;
    }

    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getHeadPortraitPath() {
        return headPortraitPath;
    }

    public void setHeadPortraitPath(String headPortraitPath) {
        this.headPortraitPath = headPortraitPath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", shopId=" + shopId + ", posId=" + posId + ", jobNumber=" + jobNumber
				+ ", staffName=" + staffName + ", password=" + password + ", staffState=" + staffState + ", createTime="
				+ createTime + ", trade=" + trade + ", headPortraitPath=" + headPortraitPath + ", phone=" + phone
				+ ", shopName=" + shopName + ", posName=" + posName + ", randomCode=" + randomCode + ", salt=" + salt
				+ "]";
	}
    
}