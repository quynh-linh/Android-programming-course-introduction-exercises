package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class OcdDivisionCountryUsStateKsPlaceKansasCity {

    @SerializedName("name")
    @Expose
    private String name;

    public OcdDivisionCountryUsStateKsPlaceKansasCity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OcdDivisionCountryUsStateKsPlaceKansasCity withName(String name) {
        this.name = name;
        return this;
    }

}