package com.forest.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseMain {
    private Integer pmId;

    private String pmOdd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliveryTime;

    private Integer supId;

    private String lister;

    private Integer shopId;

    private Date createTime;

    private String remark;
    
    private int count;
	
    private String endTime;
	
    private String startTime;
    
    private double je;
    
    private String shopName;
    
    private String supName;
    
    private int pageNum;
    
    private String statu;
    
    private List<PurchaseDetails> list;

	public List<PurchaseDetails> getList() {
		return list;
	}

	public void setList(List<PurchaseDetails> list) {
		this.list = list;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Integer getPmId() {
		return pmId;
	}

	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	public String getPmOdd() {
		return pmOdd;
	}

	public void setPmOdd(String pmOdd) {
		this.pmOdd = pmOdd;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getSupId() {
		return supId;
	}

	public void setSupId(Integer supId) {
		this.supId = supId;
	}

	public String getLister() {
		return lister;
	}

	public void setLister(String lister) {
		this.lister = lister;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public double getJe() {
		return je;
	}

	public void setJe(double je) {
		this.je = je;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
    
 
}