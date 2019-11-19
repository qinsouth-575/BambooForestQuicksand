package com.forest.entity;

import java.util.Date;

public class Staff {
    private Integer staffId;

    private Short shopId;

    private Integer posId;

    private String jobNumber;

    private String staffName;

    private String password;
    private String shopName;
    private String posName;
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

	private Integer staffState;

    private Date createTime;

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

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", shopId=" + shopId + ", posId=" + posId + ", jobNumber=" + jobNumber
				+ ", staffName=" + staffName + ", password=" + password + ", shopName=" + shopName + ", posName="
				+ posName + ", staffState=" + staffState + ", createTime=" + createTime + "]";
	}
}