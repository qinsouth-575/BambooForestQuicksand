package com.forest.entity;

public class Images {
    private Integer imgId;

    private String imgPath;

    public Images() {
		super();
	}

	public Images(Integer imgId) {
		super();
		this.imgId = imgId;
	}

	public Images(String imgPath) {
		super();
		this.imgPath = imgPath;
	}

	public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

	@Override
	public String toString() {
		return "Images [imgId=" + imgId + ", imgPath=" + imgPath + "]";
	}
    
}