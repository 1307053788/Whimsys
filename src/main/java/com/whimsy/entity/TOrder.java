package com.whimsy.entity;

import java.math.BigDecimal;

public class TOrder {
    private Integer jId;

    private Integer jMembercardId;

    private Integer jDeptId;

    private String jState;

    private BigDecimal jMoney;

    private String jOrdercode;

    private BigDecimal jIffreight;

    private BigDecimal jIfcoupon;

    private BigDecimal jIfscore;

    private BigDecimal jIfmembercard;
    
    private String jPayment;
    
    private String jAddress;

    public String getjAddress() {
		return jAddress;
	}

	public void setjAddress(String jAddress) {
		this.jAddress = jAddress;
	}

	public String getjPayment() {
		return jPayment;
	}

	public void setjPayment(String jPayment) {
		this.jPayment = jPayment;
	}

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

    public Integer getjDeptId() {
        return jDeptId;
    }

    public void setjDeptId(Integer jDeptId) {
        this.jDeptId = jDeptId;
    }

    public String getjState() {
        return jState;
    }

    public void setjState(String jState) {
        this.jState = jState == null ? null : jState.trim();
    }

    public BigDecimal getjMoney() {
        return jMoney;
    }

    public void setjMoney(BigDecimal jMoney) {
        this.jMoney = jMoney;
    }

    public String getjOrdercode() {
        return jOrdercode;
    }

    public void setjOrdercode(String jOrdercode) {
        this.jOrdercode = jOrdercode == null ? null : jOrdercode.trim();
    }

    public BigDecimal getjIffreight() {
        return jIffreight;
    }

    public void setjIffreight(BigDecimal jIffreight) {
        this.jIffreight = jIffreight;
    }

    public BigDecimal getjIfcoupon() {
        return jIfcoupon;
    }

    public void setjIfcoupon(BigDecimal jIfcoupon) {
        this.jIfcoupon = jIfcoupon;
    }

    public BigDecimal getjIfscore() {
        return jIfscore;
    }

    public void setjIfscore(BigDecimal jIfscore) {
        this.jIfscore = jIfscore;
    }

    public BigDecimal getjIfmembercard() {
        return jIfmembercard;
    }

    public void setjIfmembercard(BigDecimal jIfmembercard) {
        this.jIfmembercard = jIfmembercard;
    }
}