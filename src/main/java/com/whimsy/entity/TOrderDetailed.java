package com.whimsy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TOrderDetailed {
    private Integer jId;

    private Integer jOrderid;

    private Integer jGoodsid;

    private BigDecimal jNumber;

    private BigDecimal jGoodsmoney;
    
    private Integer jMembercardId;

    private Integer jDeptId;

    private String jState;

    private BigDecimal jMoney;

    private String jOrdercode;
    
    private String jTime;
    
    private Date jBegintime;
    
    private Date jPaytime;
    
    private Date jEndtime;
    
    private Date jUptime;
    
    private BigDecimal jAllmoney;
    
    private BigDecimal youhuimoney;
    
    private BigDecimal shijimoney;
    
    private Integer jCopId;
    
	public Integer getjCopId() {
		return jCopId;
	}

	public void setjCopId(Integer jCopId) {
		this.jCopId = jCopId;
	}

	public BigDecimal getYouhuimoney() {
		return youhuimoney;
	}

	public void setYouhuimoney(BigDecimal youhuimoney) {
		this.youhuimoney = youhuimoney;
	}

	public BigDecimal getShijimoney() {
		return shijimoney;
	}

	public void setShijimoney(BigDecimal shijimoney) {
		this.shijimoney = shijimoney;
	}

	public BigDecimal getjAllmoney() {
		return jAllmoney;
	}

	public void setjAllmoney(BigDecimal jAllmoney) {
		this.jAllmoney = jAllmoney;
	}

	public Date getjBegintime() {
		return jBegintime;
	}

	public void setjBegintime(Date jBegintime) {
		this.jBegintime = jBegintime;
	}

	public Date getjPaytime() {
		return jPaytime;
	}

	public void setjPaytime(Date jPaytime) {
		this.jPaytime = jPaytime;
	}

	public Date getjEndtime() {
		return jEndtime;
	}

	public void setjEndtime(Date jEndtime) {
		this.jEndtime = jEndtime;
	}

	public Date getjUptime() {
		return jUptime;
	}

	public void setjUptime(Date jUptime) {
		this.jUptime = jUptime;
	}

	public String getjTime() {
		return jTime;
	}

	public void setjTime(String jTime) {
		this.jTime = jTime;
	}

	public String getjAddress() {
		return jAddress;
	}

	public void setjAddress(String jAddress) {
		this.jAddress = jAddress;
	}

	private String jPayment;
    
    private String jAddress;

    public String getjPayment() {
		return jPayment;
	}

	public void setjPayment(String jPayment) {
		this.jPayment = jPayment;
	}

	private BigDecimal jIffreight;

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
		this.jState = jState;
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
		this.jOrdercode = jOrdercode;
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

	private BigDecimal jIfcoupon;

    private BigDecimal jIfscore;

    private BigDecimal jIfmembercard;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getjOrderid() {
        return jOrderid;
    }

    public void setjOrderid(Integer jOrderid) {
        this.jOrderid = jOrderid;
    }

    public Integer getjGoodsid() {
        return jGoodsid;
    }

    public void setjGoodsid(Integer jGoodsid) {
        this.jGoodsid = jGoodsid;
    }

    public BigDecimal getjNumber() {
        return jNumber;
    }

    public void setjNumber(BigDecimal jNumber) {
        this.jNumber = jNumber;
    }

    public BigDecimal getjGoodsmoney() {
        return jGoodsmoney;
    }

    public void setjGoodsmoney(BigDecimal jGoodsmoney) {
        this.jGoodsmoney = jGoodsmoney;
    }
}