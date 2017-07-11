package com.whimsy.entity;

import java.math.BigDecimal;

public class TBasicSort {
    private Integer jid;

    private String jclasscode;

    private String jclassname;

    private Integer jparentid;

    private Integer jfunctionid;

    private Integer jpriceattid;

    private Integer jfunctiontype;

    private BigDecimal jclassintegral;

    private Integer jdontshowinpos;

    private Integer jdispinnet;

    private Integer jorder;

    private String jkeywords;

    private String jdescription;

    private Integer jisparent;

    private Integer jneedproductcode;

    private Integer jexchange;

    private Integer jiscatering;

    private String jpicid;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJclasscode() {
        return jclasscode;
    }

    public void setJclasscode(String jclasscode) {
        this.jclasscode = jclasscode == null ? null : jclasscode.trim();
    }

    public String getJclassname() {
        return jclassname;
    }

    public void setJclassname(String jclassname) {
        this.jclassname = jclassname == null ? null : jclassname.trim();
    }

    public Integer getJparentid() {
        return jparentid;
    }

    public void setJparentid(Integer jparentid) {
        this.jparentid = jparentid;
    }

    public Integer getJfunctionid() {
        return jfunctionid;
    }

    public void setJfunctionid(Integer jfunctionid) {
        this.jfunctionid = jfunctionid;
    }

    public Integer getJpriceattid() {
        return jpriceattid;
    }

    public void setJpriceattid(Integer jpriceattid) {
        this.jpriceattid = jpriceattid;
    }

    public Integer getJfunctiontype() {
        return jfunctiontype;
    }

    public void setJfunctiontype(Integer jfunctiontype) {
        this.jfunctiontype = jfunctiontype;
    }

    public BigDecimal getJclassintegral() {
        return jclassintegral;
    }

    public void setJclassintegral(BigDecimal jclassintegral) {
        this.jclassintegral = jclassintegral;
    }

    public Integer getJdontshowinpos() {
        return jdontshowinpos;
    }

    public void setJdontshowinpos(Integer jdontshowinpos) {
        this.jdontshowinpos = jdontshowinpos;
    }

    public Integer getJdispinnet() {
        return jdispinnet;
    }

    public void setJdispinnet(Integer jdispinnet) {
        this.jdispinnet = jdispinnet;
    }

    public Integer getJorder() {
        return jorder;
    }

    public void setJorder(Integer jorder) {
        this.jorder = jorder;
    }

    public String getJkeywords() {
        return jkeywords;
    }

    public void setJkeywords(String jkeywords) {
        this.jkeywords = jkeywords == null ? null : jkeywords.trim();
    }

    public String getJdescription() {
        return jdescription;
    }

    public void setJdescription(String jdescription) {
        this.jdescription = jdescription == null ? null : jdescription.trim();
    }

    public Integer getJisparent() {
        return jisparent;
    }

    public void setJisparent(Integer jisparent) {
        this.jisparent = jisparent;
    }

    public Integer getJneedproductcode() {
        return jneedproductcode;
    }

    public void setJneedproductcode(Integer jneedproductcode) {
        this.jneedproductcode = jneedproductcode;
    }

    public Integer getJexchange() {
        return jexchange;
    }

    public void setJexchange(Integer jexchange) {
        this.jexchange = jexchange;
    }

    public Integer getJiscatering() {
        return jiscatering;
    }

    public void setJiscatering(Integer jiscatering) {
        this.jiscatering = jiscatering;
    }

    public String getJpicid() {
        return jpicid;
    }

    public void setJpicid(String jpicid) {
        this.jpicid = jpicid == null ? null : jpicid.trim();
    }
}