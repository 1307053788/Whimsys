package com.whimsy.entity;

import java.math.BigDecimal;

public class VAuxGoodsStock {
    private Integer jdeptid;

    private Integer jstockid;

    private Integer jclassid;

    private TGoods tGoods;

	private Integer jauxattid1;

    private Integer jauxattid2;

    private BigDecimal jstockqty;

    private BigDecimal jnowqty;

    private BigDecimal jensendqty;

    private BigDecimal jcostamt;

    private BigDecimal jcostprice;

    private Boolean jnouse;

    private Integer jmainproductsmark;
    
    public Integer getJdeptid() {
        return jdeptid;
    }

    public void setJdeptid(Integer jdeptid) {
        this.jdeptid = jdeptid;
    }

    public Integer getJstockid() {
        return jstockid;
    }

    public void setJstockid(Integer jstockid) {
        this.jstockid = jstockid;
    }

    public Integer getJclassid() {
        return jclassid;
    }

    public void setJclassid(Integer jclassid) {
        this.jclassid = jclassid;
    }

    public TGoods gettGoods() {
		return tGoods;
	}

	public void settGoods(TGoods tGoods) {
		this.tGoods = tGoods;
	}

    public Integer getJauxattid1() {
        return jauxattid1;
    }

    public void setJauxattid1(Integer jauxattid1) {
        this.jauxattid1 = jauxattid1;
    }

    public Integer getJauxattid2() {
        return jauxattid2;
    }

    public void setJauxattid2(Integer jauxattid2) {
        this.jauxattid2 = jauxattid2;
    }

    public BigDecimal getJstockqty() {
        return jstockqty;
    }

    public void setJstockqty(BigDecimal jstockqty) {
        this.jstockqty = jstockqty;
    }

    public BigDecimal getJnowqty() {
        return jnowqty;
    }

    public void setJnowqty(BigDecimal jnowqty) {
        this.jnowqty = jnowqty;
    }

    public BigDecimal getJensendqty() {
        return jensendqty;
    }

    public void setJensendqty(BigDecimal jensendqty) {
        this.jensendqty = jensendqty;
    }

    public BigDecimal getJcostamt() {
        return jcostamt;
    }

    public void setJcostamt(BigDecimal jcostamt) {
        this.jcostamt = jcostamt;
    }

    public BigDecimal getJcostprice() {
        return jcostprice;
    }

    public void setJcostprice(BigDecimal jcostprice) {
        this.jcostprice = jcostprice;
    }

    public Boolean getJnouse() {
        return jnouse;
    }

    public void setJnouse(Boolean jnouse) {
        this.jnouse = jnouse;
    }

    public Integer getJmainproductsmark() {
        return jmainproductsmark;
    }

    public void setJmainproductsmark(Integer jmainproductsmark) {
        this.jmainproductsmark = jmainproductsmark;
    }
}