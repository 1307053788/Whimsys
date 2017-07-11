package com.whimsy.entity;

public class TDeliveryAddress {
    private Integer jId;

    private Integer jMembercardId;

    private String jDeliveryMan;

    private String jDeliveryPhone;

    private String jAddress;

    private String jAddressDetailed;

    private String jLable;

    private String jDefault;

    private String jLongitude;

    private String jLatitude;

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

    public String getjDeliveryMan() {
        return jDeliveryMan;
    }

    public void setjDeliveryMan(String jDeliveryMan) {
        this.jDeliveryMan = jDeliveryMan == null ? null : jDeliveryMan.trim();
    }

    public String getjDeliveryPhone() {
        return jDeliveryPhone;
    }

    public void setjDeliveryPhone(String jDeliveryPhone) {
        this.jDeliveryPhone = jDeliveryPhone == null ? null : jDeliveryPhone.trim();
    }

    public String getjAddress() {
        return jAddress;
    }

    public void setjAddress(String jAddress) {
        this.jAddress = jAddress == null ? null : jAddress.trim();
    }

    public String getjAddressDetailed() {
        return jAddressDetailed;
    }

    public void setjAddressDetailed(String jAddressDetailed) {
        this.jAddressDetailed = jAddressDetailed == null ? null : jAddressDetailed.trim();
    }

    public String getjLable() {
        return jLable;
    }

    public void setjLable(String jLable) {
        this.jLable = jLable == null ? null : jLable.trim();
    }

    public String getjDefault() {
        return jDefault;
    }

    public void setjDefault(String jDefault) {
        this.jDefault = jDefault == null ? null : jDefault.trim();
    }

    public String getjLongitude() {
        return jLongitude;
    }

    public void setjLongitude(String jLongitude) {
        this.jLongitude = jLongitude == null ? null : jLongitude.trim();
    }

    public String getjLatitude() {
        return jLatitude;
    }

    public void setjLatitude(String jLatitude) {
        this.jLatitude = jLatitude == null ? null : jLatitude.trim();
    }
}