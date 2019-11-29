package com.forest.entity;

public class CmImgRelation {
    private Integer cirId;

    private Integer cmId;

    private Integer imgId;

    private Integer isMain;

    public CmImgRelation() {
		super();
	}

	public CmImgRelation(Integer cmId, Integer imgId, Integer isMain) {
		super();
		this.cmId = cmId;
		this.imgId = imgId;
		this.isMain = isMain;
	}

	public CmImgRelation(Integer cirId, Integer cmId, Integer imgId, Integer isMain) {
		super();
		this.cirId = cirId;
		this.cmId = cmId;
		this.imgId = imgId;
		this.isMain = isMain;
	}

	public Integer getCirId() {
        return cirId;
    }

    public void setCirId(Integer cirId) {
        this.cirId = cirId;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }
}