package com.forest.entity;

public class CommodityType {
    private Integer ctId;

    private String ctName;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

	@Override
	public String toString() {
		return "CommodityType [ctId=" + ctId + ", ctName=" + ctName + "]";
	}
    
}