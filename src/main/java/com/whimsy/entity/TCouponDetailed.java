package com.whimsy.entity;

import java.math.BigDecimal;

public class TCouponDetailed {
    private Integer jId;

    private Integer jCouponId;

    private Integer jMembercardId;

    private String jState;

    private String jGetdata;
    
    private String jOutdata;
    
    public String getjOutdata() {
		return jOutdata;
	}

	public void setjOutdata(String jOutdata) {
		this.jOutdata = jOutdata;
	}

	private Integer jDeptId;
    
    private BigDecimal jQuota;
    
    private String jAdddata;

    private String jCondata;
    
    private BigDecimal jFulln;
    
    private BigDecimal jnumber;

    public Integer getjDeptId() {
		return jDeptId;
	}

	public void setjDeptId(Integer jDeptId) {
		this.jDeptId = jDeptId;
	}

	public BigDecimal getjQuota() {
		return jQuota;
	}

	public void setjQuota(BigDecimal jQuota) {
		this.jQuota = jQuota;
	}

	public String getjAdddata() {
		return jAdddata;
	}

	public void setjAdddata(String jAdddata) {
		this.jAdddata = jAdddata;
	}

	public String getjCondata() {
		return jCondata;
	}

	public void setjCondata(String jCondata) {
		this.jCondata = jCondata;
	}

	public BigDecimal getjFulln() {
		return jFulln;
	}

	public void setjFulln(BigDecimal jFulln) {
		this.jFulln = jFulln;
	}

	public BigDecimal getJnumber() {
		return jnumber;
	}

	public void setJnumber(BigDecimal jnumber) {
		this.jnumber = jnumber;
	}

	public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getjCouponId() {
        return jCouponId;
    }

    public void setjCouponId(Integer jCouponId) {
        this.jCouponId = jCouponId;
    }

    public Integer getjMembercardId() {
        return jMembercardId;
    }

    public void setjMembercardId(Integer jMembercardId) {
        this.jMembercardId = jMembercardId;
    }

    public String getjState() {
        return jState;
    }

    public void setjState(String jState) {
        this.jState = jState == null ? null : jState.trim();
    }

    public String getjGetdata() {
        return jGetdata;
    }

    public void setjGetdata(String jGetdata) {
        this.jGetdata = jGetdata == null ? null : jGetdata.trim();
    }
}