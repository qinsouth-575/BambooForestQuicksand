package com.forest.entity;

public class Color {
    private Integer colorId;

    private String colorName;

    private Integer parentGcId;

    private String colorPrcture;

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getParentGcId() {
        return parentGcId;
    }

    public void setParentGcId(Integer parentGcId) {
        this.parentGcId = parentGcId;
    }

    public String getColorPrcture() {
        return colorPrcture;
    }

    public void setColorPrcture(String colorPrcture) {
        this.colorPrcture = colorPrcture;
    }
}