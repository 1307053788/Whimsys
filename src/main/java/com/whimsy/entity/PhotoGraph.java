package com.whimsy.entity;

public class PhotoGraph {
    private Integer photographId;

    private Integer photoId;

    private String photographAddress;

    public Integer getPhotographId() {
        return photographId;
    }

    public void setPhotographId(Integer photographId) {
        this.photographId = photographId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotographAddress() {
        return photographAddress;
    }

    public void setPhotographAddress(String photographAddress) {
        this.photographAddress = photographAddress == null ? null : photographAddress.trim();
    }
}