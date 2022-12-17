package com.example.baitapquatrinh.BaiTap3;

public class proteinsModel {
    private String title;
    private String description;
    private String guid;
    private String pubDate;
    private String link;
    private String mediaContentUrl;
    private String mediaTitle;
    private String mediaDescription;

    public proteinsModel(String title, String description, String guid, String pubDate, String link, String mediaContentUrl, String mediaTitle, String mediaDescription) {
        this.title = title;
        this.description = description;
        this.guid = guid;
        this.pubDate = pubDate;
        this.link = link;
        this.mediaContentUrl = mediaContentUrl;
        this.mediaTitle = mediaTitle;
        this.mediaDescription = mediaDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMediaContentUrl() {
        return mediaContentUrl;
    }

    public void setMediaContentUrl(String mediaContentUrl) {
        this.mediaContentUrl = mediaContentUrl;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }
}
