package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

public class Address implements Serializable {

    @SerializedName("line1")
    @Expose
    private String line1;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("line2")
    @Expose
    private String line2;
    @SerializedName("line3")
    @Expose
    private String line3;

    public Address(String line1, String city, String state, String zip, String line2, String line3) {
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.line2 = line2;
        this.line3 = line3;
    }
    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Address withLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Address withZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Address withLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public Address withLine3(String line3) {
        this.line3 = line3;
        return this;
    }

}