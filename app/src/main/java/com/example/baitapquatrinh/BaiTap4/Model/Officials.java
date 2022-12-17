package com.example.baitapquatrinh.BaiTap4.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Officials {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private ArrayList<Address> address = null;
    @SerializedName("party")
    @Expose
    private String party;
    @SerializedName("phones")
    @Expose
    private ArrayList<String> phones = null;
    @SerializedName("urls")
    @Expose
    private ArrayList<String> urls = null;
    @SerializedName("channels")
    @Expose
    private ArrayList<Channels> channels = null;
    @SerializedName("geocodingSummaries")
    @Expose
    private List<GeocodingSummaries> geocodingSummaries = null;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;
    @SerializedName("emails")
    @Expose
    private ArrayList<String> emails = null;

    public Officials(String name, ArrayList<Address> address, String party, ArrayList<String> phones, ArrayList<String> urls, ArrayList<Channels> channels, List<GeocodingSummaries> geocodingSummaries, String photoUrl, ArrayList<String> emails) {
        this.name = name;
        this.address = address;
        this.party = party;
        this.phones = phones;
        this.urls = urls;
        this.channels = channels;
        this.geocodingSummaries = geocodingSummaries;
        this.photoUrl = photoUrl;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Officials withName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public Officials withAddress(ArrayList<Address> address) {
        this.address = address;
        return this;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Officials withParty(String party) {
        this.party = party;
        return this;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public Officials withPhones(ArrayList<String> phones) {
        this.phones = phones;
        return this;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public Officials withUrls(ArrayList<String> urls) {
        this.urls = urls;
        return this;
    }

    public ArrayList<Channels> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channels> channels) {
        this.channels = channels;
    }

    public Officials withChannels(ArrayList<Channels> channels) {
        this.channels = channels;
        return this;
    }

    public List<GeocodingSummaries> getGeocodingSummaries() {
        return geocodingSummaries;
    }

    public void setGeocodingSummaries(List<GeocodingSummaries> geocodingSummaries) {
        this.geocodingSummaries = geocodingSummaries;
    }

    public Officials withGeocodingSummaries(List<GeocodingSummaries> geocodingSummaries) {
        this.geocodingSummaries = geocodingSummaries;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Officials withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public Officials withEmails(ArrayList<String> emails) {
        this.emails = emails;
        return this;
    }

}