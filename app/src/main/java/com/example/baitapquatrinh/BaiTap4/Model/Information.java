package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Information {

    @SerializedName("normalizedInput")
    @Expose
    private NormalizedInput normalizedInput;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("divisions")
    @Expose
    private Divisions divisions;
    @SerializedName("offices")
    @Expose
    private List<Offices> offices = null;
    @SerializedName("officials")
    @Expose
    private List<Officials> officials = null;

    public Information(NormalizedInput normalizedInput, String kind, Divisions divisions, List<Offices> offices, List<Officials> officials) {
        this.normalizedInput = normalizedInput;
        this.kind = kind;
        this.divisions = divisions;
        this.offices = offices;
        this.officials = officials;
    }
    public NormalizedInput getNormalizedInput() {
        return normalizedInput;
    }

    public void setNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
    }

    public Information withNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Information withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Divisions getDivisions() {
        return divisions;
    }

    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }

    public Information withDivisions(Divisions divisions) {
        this.divisions = divisions;
        return this;
    }

    public List<Offices> getOffices() {
        return offices;
    }

    public void setOffices(List<Offices> offices) {
        this.offices = offices;
    }

    public Information withOffices(List<Offices> offices) {
        this.offices = offices;
        return this;
    }

    public List<Officials> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Officials> officials) {
        this.officials = officials;
    }

    public Information withOfficials(List<Officials> officials) {
        this.officials = officials;
        return this;
    }

}