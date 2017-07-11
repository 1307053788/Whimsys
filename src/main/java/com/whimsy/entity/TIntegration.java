package com.whimsy.entity;

public class TIntegration {
    private Integer jId;

    private Integer jMembercardId;

    private String jType;

    private String jCode;

    private Long jQuota;

    private Long jUpcoupon;

    private String jData;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getjMembercardId() {
        return jMembercardId;
    }

    public void setjMembercardId(Integer jMembercardId) {
        this.jMembercardId = jMembercardId;
    }

    public String getjType() {
        return jType;
    }

    public void setjType(String jType) {
        this.jType = jType == null ? null : jType.trim();
    }

    public String getjCode() {
        return jCode;
    }

    public void setjCode(String jCode) {
        this.jCode = jCode == null ? null : jCode.trim();
    }

    public Long getjQuota() {
        return jQuota;
    }

    public void setjQuota(Long jQuota) {
        this.jQuota = jQuota;
    }

    public Long getjUpcoupon() {
        return jUpcoupon;
    }

    public void setjUpcoupon(Long jUpcoupon) {
        this.jUpcoupon = jUpcoupon;
    }

    public String getjData() {
        return jData;
    }

    public void setjData(String jData) {
        this.jData = jData == null ? null : jData.trim();
    }
}