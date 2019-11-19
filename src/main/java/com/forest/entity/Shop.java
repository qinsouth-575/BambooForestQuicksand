package com.forest.entity;

public class Shop {
    private Short shopId;

    private String account;

    private String shopName;

    private String phone;

    private String telephone;

    private String province;

    private String city;

    private String region;

    private String street;

    private String info;
    private int staffcount;
    
    @Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", account=" + account + ", shopName=" + shopName + ", phone=" + phone
				+ ", telephone=" + telephone + ", province=" + province + ", city=" + city + ", region=" + region
				+ ", street=" + street + ", info=" + info + ", staffcount=" + staffcount + ", linkman=" + linkman + "]";
	}

	public int getStaffcount() {
		return staffcount;
	}

	public void setStaffcount(int staffcount) {
		this.staffcount = staffcount;
	}

	public Short getShopId() {
        return shopId;
    }

    public void setShopId(Short shopId) {
        this.shopId = shopId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    private String linkman;
    public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}