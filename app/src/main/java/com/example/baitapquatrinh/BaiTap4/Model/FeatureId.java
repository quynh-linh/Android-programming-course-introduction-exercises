package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class FeatureId {

    @SerializedName("cellId")
    @Expose
    private String cellId;
    @SerializedName("fprint")
    @Expose
    private String fprint;


    public FeatureId(String cellId, String fprint) {
        this.cellId = cellId;
        this.fprint = fprint;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public FeatureId withCellId(String cellId) {
        this.cellId = cellId;
        return this;
    }

    public String getFprint() {
        return fprint;
    }

    public void setFprint(String fprint) {
        this.fprint = fprint;
    }

    public FeatureId withFprint(String fprint) {
        this.fprint = fprint;
        return this;
    }

}
