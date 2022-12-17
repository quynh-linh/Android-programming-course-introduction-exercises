package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Divisions {

    @SerializedName("ocd-division/country:us/state:ks/cd:3")
    @Expose
    private OcdDivisionCountryUsStateKsCd3 ocdDivisionCountryUsStateKsCd3;
    @SerializedName("ocd-division/country:us")
    @Expose
    private OcdDivisionCountryUs ocdDivisionCountryUs;
    @SerializedName("ocd-division/country:us/state:ks/county:wyandotte")
    @Expose
    private OcdDivisionCountryUsStateKsCountyWyandotte ocdDivisionCountryUsStateKsCountyWyandotte;
    @SerializedName("ocd-division/country:us/state:ks")
    @Expose
    private OcdDivisionCountryUsStateKs ocdDivisionCountryUsStateKs;
    @SerializedName("ocd-division/country:us/state:ks/place:kansas_city")
    @Expose
    private OcdDivisionCountryUsStateKsPlaceKansasCity ocdDivisionCountryUsStateKsPlaceKansasCity;

    public Divisions(OcdDivisionCountryUsStateKsCd3 ocdDivisionCountryUsStateKsCd3, OcdDivisionCountryUs ocdDivisionCountryUs, OcdDivisionCountryUsStateKsCountyWyandotte ocdDivisionCountryUsStateKsCountyWyandotte, OcdDivisionCountryUsStateKs ocdDivisionCountryUsStateKs, OcdDivisionCountryUsStateKsPlaceKansasCity ocdDivisionCountryUsStateKsPlaceKansasCity) {
        this.ocdDivisionCountryUsStateKsCd3 = ocdDivisionCountryUsStateKsCd3;
        this.ocdDivisionCountryUs = ocdDivisionCountryUs;
        this.ocdDivisionCountryUsStateKsCountyWyandotte = ocdDivisionCountryUsStateKsCountyWyandotte;
        this.ocdDivisionCountryUsStateKs = ocdDivisionCountryUsStateKs;
        this.ocdDivisionCountryUsStateKsPlaceKansasCity = ocdDivisionCountryUsStateKsPlaceKansasCity;
    }

    public OcdDivisionCountryUsStateKsCd3 getOcdDivisionCountryUsStateKsCd3() {
        return ocdDivisionCountryUsStateKsCd3;
    }

    public void setOcdDivisionCountryUsStateKsCd3(OcdDivisionCountryUsStateKsCd3 ocdDivisionCountryUsStateKsCd3) {
        this.ocdDivisionCountryUsStateKsCd3 = ocdDivisionCountryUsStateKsCd3;
    }

    public Divisions withOcdDivisionCountryUsStateKsCd3(OcdDivisionCountryUsStateKsCd3 ocdDivisionCountryUsStateKsCd3) {
        this.ocdDivisionCountryUsStateKsCd3 = ocdDivisionCountryUsStateKsCd3;
        return this;
    }

    public OcdDivisionCountryUs getOcdDivisionCountryUs() {
        return ocdDivisionCountryUs;
    }

    public void setOcdDivisionCountryUs(OcdDivisionCountryUs ocdDivisionCountryUs) {
        this.ocdDivisionCountryUs = ocdDivisionCountryUs;
    }

    public Divisions withOcdDivisionCountryUs(OcdDivisionCountryUs ocdDivisionCountryUs) {
        this.ocdDivisionCountryUs = ocdDivisionCountryUs;
        return this;
    }

    public OcdDivisionCountryUsStateKsCountyWyandotte getOcdDivisionCountryUsStateKsCountyWyandotte() {
        return ocdDivisionCountryUsStateKsCountyWyandotte;
    }

    public void setOcdDivisionCountryUsStateKsCountyWyandotte(OcdDivisionCountryUsStateKsCountyWyandotte ocdDivisionCountryUsStateKsCountyWyandotte) {
        this.ocdDivisionCountryUsStateKsCountyWyandotte = ocdDivisionCountryUsStateKsCountyWyandotte;
    }

    public Divisions withOcdDivisionCountryUsStateKsCountyWyandotte(OcdDivisionCountryUsStateKsCountyWyandotte ocdDivisionCountryUsStateKsCountyWyandotte) {
        this.ocdDivisionCountryUsStateKsCountyWyandotte = ocdDivisionCountryUsStateKsCountyWyandotte;
        return this;
    }

    public OcdDivisionCountryUsStateKs getOcdDivisionCountryUsStateKs() {
        return ocdDivisionCountryUsStateKs;
    }

    public void setOcdDivisionCountryUsStateKs(OcdDivisionCountryUsStateKs ocdDivisionCountryUsStateKs) {
        this.ocdDivisionCountryUsStateKs = ocdDivisionCountryUsStateKs;
    }

    public Divisions withOcdDivisionCountryUsStateKs(OcdDivisionCountryUsStateKs ocdDivisionCountryUsStateKs) {
        this.ocdDivisionCountryUsStateKs = ocdDivisionCountryUsStateKs;
        return this;
    }

    public OcdDivisionCountryUsStateKsPlaceKansasCity getOcdDivisionCountryUsStateKsPlaceKansasCity() {
        return ocdDivisionCountryUsStateKsPlaceKansasCity;
    }

    public void setOcdDivisionCountryUsStateKsPlaceKansasCity(OcdDivisionCountryUsStateKsPlaceKansasCity ocdDivisionCountryUsStateKsPlaceKansasCity) {
        this.ocdDivisionCountryUsStateKsPlaceKansasCity = ocdDivisionCountryUsStateKsPlaceKansasCity;
    }

    public Divisions withOcdDivisionCountryUsStateKsPlaceKansasCity(OcdDivisionCountryUsStateKsPlaceKansasCity ocdDivisionCountryUsStateKsPlaceKansasCity) {
        this.ocdDivisionCountryUsStateKsPlaceKansasCity = ocdDivisionCountryUsStateKsPlaceKansasCity;
        return this;
    }

}