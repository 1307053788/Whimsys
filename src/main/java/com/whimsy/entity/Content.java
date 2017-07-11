package com.whimsy.entity;

public class Content {
    private Integer contentId;

    private String contentCharacter;

    private String contentImages;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentCharacter() {
        return contentCharacter;
    }

    public void setContentCharacter(String contentCharacter) {
        this.contentCharacter = contentCharacter == null ? null : contentCharacter.trim();
    }

    public String getContentImages() {
        return contentImages;
    }

    public void setContentImages(String contentImages) {
        this.contentImages = contentImages == null ? null : contentImages.trim();
    }
}