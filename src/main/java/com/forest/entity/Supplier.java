package com.forest.entity;

public class Supplier {
    private Integer supId;

    @Override
	public String toString() {
		return "Supplier [supId=" + supId + ", companyName=" + companyName + ", shortName=" + shortName + ", linkman="
				+ linkman + ", phone=" + phone + ", email=" + email + ", telephone=" + telephone + ", province="
				+ province + ", city=" + city + ", region=" + region + ", street=" + street + ", pageNum=" + pageNum
				+ "]";
	}

	private String companyName;

    private String shortName;

    private String linkman;

    private String phone;

    private String email;

    private String telephone;

    private String province;

    private String city;

    private String region;

    private String street;
    
    public int pageNum;

    public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    
}