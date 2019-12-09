package com.forest.entity;

public class Jurisdiction {
    private Integer jurId;

    private String description;

    private Integer parentJurId;

    private String jurName;

    public Integer getJurId() {
        return jurId;
    }

    public void setJurId(Integer jurId) {
        this.jurId = jurId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentJurId() {
        return parentJurId;
    }

    public void setParentJurId(Integer parentJurId) {
        this.parentJurId = parentJurId;
    }

    public String getJurName() {
        return jurName;
    }

    public void setJurName(String jurName) {
        this.jurName = jurName;
    }
}