package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Offices {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("divisionId")
    @Expose
    private String divisionId;
    @SerializedName("levels")
    @Expose
    private List<String> levels = null;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("officialIndices")
    @Expose
    private ArrayList<Integer> officialIndices = null;

    public Offices(String name, String divisionId, List<String> levels, List<String> roles, ArrayList<Integer> officialIndices) {
        this.name = name;
        this.divisionId = divisionId;
        this.levels = levels;
        this.roles = roles;
        this.officialIndices = officialIndices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Offices withName(String name) {
        this.name = name;
        return this;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public Offices withDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }

    public Offices withLevels(List<String> levels) {
        this.levels = levels;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Offices withRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public ArrayList<Integer> getOfficialIndices() {
        return officialIndices;
    }

    public void setOfficialIndices(ArrayList<Integer> officialIndices) {
        this.officialIndices = officialIndices;
    }

    public Offices withOfficialIndices(ArrayList<Integer> officialIndices) {
        this.officialIndices = officialIndices;
        return this;
    }

}
