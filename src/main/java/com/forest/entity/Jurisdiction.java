package com.forest.entity;

public class Jurisdiction {
    private Integer jurId;

    private String jurName;

    private Integer parentJurId;

    public Integer getJurId() {
        return jurId;
    }

    public void setJurId(Integer jurId) {
        this.jurId = jurId;
    }

    public String getJurName() {
        return jurName;
    }

    public void setJurName(String jurName) {
        this.jurName = jurName;
    }

    public Integer getParentJurId() {
        return parentJurId;
    }

    public void setParentJurId(Integer parentJurId) {
        this.parentJurId = parentJurId;
    }
}