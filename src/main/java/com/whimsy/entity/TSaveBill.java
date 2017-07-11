package com.whimsy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TSaveBill {
    private Integer jid;

    private String jbillcode;

    private Date jbilldate;

    private Integer jdeptid;

    private Integer jbilltype;

    private Integer jsavecardid;

    private BigDecimal jbillamt;

    private Integer jhandleid;

    private Integer jinputrid;

    private Integer juseid;

    private String jmemo;

    private Integer jcardtype;

    private BigDecimal jcashamt;

    private BigDecimal jdiscrate;

    private Integer jbankid;

    private BigDecimal jendamt;

    private BigDecimal jfilltimes;

    private Integer jmachineid;

    private Integer jfillsourceid;

    private String jfillcode;

    private BigDecimal jintegral;

    private String jtransactionid;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJbillcode() {
        return jbillcode;
    }

    public void setJbillcode(String jbillcode) {
        this.jbillcode = jbillcode == null ? null : jbillcode.trim();
    }

    public Date getJbilldate() {
        return jbilldate;
    }

    public void setJbilldate(Date jbilldate) {
        this.jbilldate = jbilldate;
    }

    public Integer getJdeptid() {
        return jdeptid;
    }

    public void setJdeptid(Integer jdeptid) {
        this.jdeptid = jdeptid;
    }

    public Integer getJbilltype() {
        return jbilltype;
    }

    public void setJbilltype(Integer jbilltype) {
        this.jbilltype = jbilltype;
    }

    public Integer getJsavecardid() {
        return jsavecardid;
    }

    public void setJsavecardid(Integer jsavecardid) {
        this.jsavecardid = jsavecardid;
    }

    public BigDecimal getJbillamt() {
        return jbillamt;
    }

    public void setJbillamt(BigDecimal jbillamt) {
        this.jbillamt = jbillamt;
    }

    public Integer getJhandleid() {
        return jhandleid;
    }

    public void setJhandleid(Integer jhandleid) {
        this.jhandleid = jhandleid;
    }

    public Integer getJinputrid() {
        return jinputrid;
    }

    public void setJinputrid(Integer jinputrid) {
        this.jinputrid = jinputrid;
    }

    public Integer getJuseid() {
        return juseid;
    }

    public void setJuseid(Integer juseid) {
        this.juseid = juseid;
    }

    public String getJmemo() {
        return jmemo;
    }

    public void setJmemo(String jmemo) {
        this.jmemo = jmemo == null ? null : jmemo.trim();
    }

    public Integer getJcardtype() {
        return jcardtype;
    }

    public void setJcardtype(Integer jcardtype) {
        this.jcardtype = jcardtype;
    }

    public BigDecimal getJcashamt() {
        return jcashamt;
    }

    public void setJcashamt(BigDecimal jcashamt) {
        this.jcashamt = jcashamt;
    }

    public BigDecimal getJdiscrate() {
        return jdiscrate;
    }

    public void setJdiscrate(BigDecimal jdiscrate) {
        this.jdiscrate = jdiscrate;
    }

    public Integer getJbankid() {
        return jbankid;
    }

    public void setJbankid(Integer jbankid) {
        this.jbankid = jbankid;
    }

    public BigDecimal getJendamt() {
        return jendamt;
    }

    public void setJendamt(BigDecimal jendamt) {
        this.jendamt = jendamt;
    }

    public BigDecimal getJfilltimes() {
        return jfilltimes;
    }

    public void setJfilltimes(BigDecimal jfilltimes) {
        this.jfilltimes = jfilltimes;
    }

    public Integer getJmachineid() {
        return jmachineid;
    }

    public void setJmachineid(Integer jmachineid) {
        this.jmachineid = jmachineid;
    }

    public Integer getJfillsourceid() {
        return jfillsourceid;
    }

    public void setJfillsourceid(Integer jfillsourceid) {
        this.jfillsourceid = jfillsourceid;
    }

    public String getJfillcode() {
        return jfillcode;
    }

    public void setJfillcode(String jfillcode) {
        this.jfillcode = jfillcode == null ? null : jfillcode.trim();
    }

    public BigDecimal getJintegral() {
        return jintegral;
    }

    public void setJintegral(BigDecimal jintegral) {
        this.jintegral = jintegral;
    }

    public String getJtransactionid() {
        return jtransactionid;
    }

    public void setJtransactionid(String jtransactionid) {
        this.jtransactionid = jtransactionid == null ? null : jtransactionid.trim();
    }
}