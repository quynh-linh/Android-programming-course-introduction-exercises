package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class GeocodingSummaries {

    @SerializedName("queryString")
    @Expose
    private String queryString;
    @SerializedName("featureId")
    @Expose
    private FeatureId featureId;
    @SerializedName("featureType")
    @Expose
    private String featureType;
    @SerializedName("positionPrecisionMeters")
    @Expose
    private Integer positionPrecisionMeters;
    @SerializedName("addressUnderstood")
    @Expose
    private Boolean addressUnderstood;

    public GeocodingSummaries(String queryString, FeatureId featureId, String featureType, Integer positionPrecisionMeters, Boolean addressUnderstood) {
        this.queryString = queryString;
        this.featureId = featureId;
        this.featureType = featureType;
        this.positionPrecisionMeters = positionPrecisionMeters;
        this.addressUnderstood = addressUnderstood;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public GeocodingSummaries withQueryString(String queryString) {
        this.queryString = queryString;
        return this;
    }

    public FeatureId getFeatureId() {
        return featureId;
    }

    public void setFeatureId(FeatureId featureId) {
        this.featureId = featureId;
    }

    public GeocodingSummaries withFeatureId(FeatureId featureId) {
        this.featureId = featureId;
        return this;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public GeocodingSummaries withFeatureType(String featureType) {
        this.featureType = featureType;
        return this;
    }

    public Integer getPositionPrecisionMeters() {
        return positionPrecisionMeters;
    }

    public void setPositionPrecisionMeters(Integer positionPrecisionMeters) {
        this.positionPrecisionMeters = positionPrecisionMeters;
    }

    public GeocodingSummaries withPositionPrecisionMeters(Integer positionPrecisionMeters) {
        this.positionPrecisionMeters = positionPrecisionMeters;
        return this;
    }

    public Boolean getAddressUnderstood() {
        return addressUnderstood;
    }

    public void setAddressUnderstood(Boolean addressUnderstood) {
        this.addressUnderstood = addressUnderstood;
    }

    public GeocodingSummaries withAddressUnderstood(Boolean addressUnderstood) {
        this.addressUnderstood = addressUnderstood;
        return this;
    }

}