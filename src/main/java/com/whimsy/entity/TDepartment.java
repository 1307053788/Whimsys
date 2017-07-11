package com.whimsy.entity;

import java.math.BigDecimal;

public class TDepartment {
    private Integer jid;

    private String jclasscode;

    private String jclassname;

    private Integer jparentid;

    private Integer jdepttype;

    private String jemail;

    private String jtele;

    private String jaddress;

    private Integer jfunctionid;

    private Integer jareaid;

    private String jmemo;

    private Integer jindiedeptid;

    private String jmobilenumber;

    private String jaddxylocation;

    private Boolean jnouse;

    private Integer jempid;

    private Integer jisdisponapp;

    private String jcountrycode;

    private String jprovincecode;

    private String jcitycode;

    private String jcountycode;

    private String jlongitude;

    private String jdimension;

    private String jradius;
    
    private BigDecimal jsign;
    
    private BigDecimal jscoreforrmb;
    
    private BigDecimal jfullrmb;
    
    private BigDecimal jreduce;
    
    private String jphoto;

    public String getJphoto() {
		return jphoto;
	}

	public void setJphoto(String jphoto) {
		this.jphoto = jphoto;
	}

	public BigDecimal getJfullrmb() {
		return jfullrmb;
	}

	public void setJfullrmb(BigDecimal jfullrmb) {
		this.jfullrmb = jfullrmb;
	}

	public BigDecimal getJreduce() {
		return jreduce;
	}

	public void setJreduce(BigDecimal jreduce) {
		this.jreduce = jreduce;
	}

	public BigDecimal getJscoreforrmb() {
		return jscoreforrmb;
	}

	public void setJscoreforrmb(BigDecimal jscoreforrmb) {
		this.jscoreforrmb = jscoreforrmb;
	}

	public BigDecimal getJsign() {
		return jsign;
	}

	public void setJsign(BigDecimal jsign) {
		this.jsign = jsign;
	}

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

    public Integer getJdepttype() {
        return jdepttype;
    }

    public void setJdepttype(Integer jdepttype) {
        this.jdepttype = jdepttype;
    }

    public String getJemail() {
        return jemail;
    }

    public void setJemail(String jemail) {
        this.jemail = jemail == null ? null : jemail.trim();
    }

    public String getJtele() {
        return jtele;
    }

    public void setJtele(String jtele) {
        this.jtele = jtele == null ? null : jtele.trim();
    }

    public String getJaddress() {
        return jaddress;
    }

    public void setJaddress(String jaddress) {
        this.jaddress = jaddress == null ? null : jaddress.trim();
    }

    public Integer getJfunctionid() {
        return jfunctionid;
    }

    public void setJfunctionid(Integer jfunctionid) {
        this.jfunctionid = jfunctionid;
    }

    public Integer getJareaid() {
        return jareaid;
    }

    public void setJareaid(Integer jareaid) {
        this.jareaid = jareaid;
    }

    public String getJmemo() {
        return jmemo;
    }

    public void setJmemo(String jmemo) {
        this.jmemo = jmemo == null ? null : jmemo.trim();
    }

    public Integer getJindiedeptid() {
        return jindiedeptid;
    }

    public void setJindiedeptid(Integer jindiedeptid) {
        this.jindiedeptid = jindiedeptid;
    }

    public String getJmobilenumber() {
        return jmobilenumber;
    }

    public void setJmobilenumber(String jmobilenumber) {
        this.jmobilenumber = jmobilenumber == null ? null : jmobilenumber.trim();
    }

    public String getJaddxylocation() {
        return jaddxylocation;
    }

    public void setJaddxylocation(String jaddxylocation) {
        this.jaddxylocation = jaddxylocation == null ? null : jaddxylocation.trim();
    }

    public Boolean getJnouse() {
        return jnouse;
    }

    public void setJnouse(Boolean jnouse) {
        this.jnouse = jnouse;
    }

    public Integer getJempid() {
        return jempid;
    }

    public void setJempid(Integer jempid) {
        this.jempid = jempid;
    }

    public Integer getJisdisponapp() {
        return jisdisponapp;
    }

    public void setJisdisponapp(Integer jisdisponapp) {
        this.jisdisponapp = jisdisponapp;
    }

    public String getJcountrycode() {
        return jcountrycode;
    }

    public void setJcountrycode(String jcountrycode) {
        this.jcountrycode = jcountrycode == null ? null : jcountrycode.trim();
    }

    public String getJprovincecode() {
        return jprovincecode;
    }

    public void setJprovincecode(String jprovincecode) {
        this.jprovincecode = jprovincecode == null ? null : jprovincecode.trim();
    }

    public String getJcitycode() {
        return jcitycode;
    }

    public void setJcitycode(String jcitycode) {
        this.jcitycode = jcitycode == null ? null : jcitycode.trim();
    }

    public String getJcountycode() {
        return jcountycode;
    }

    public void setJcountycode(String jcountycode) {
        this.jcountycode = jcountycode == null ? null : jcountycode.trim();
    }

    public String getJlongitude() {
        return jlongitude;
    }

    public void setJlongitude(String jlongitude) {
        this.jlongitude = jlongitude == null ? null : jlongitude.trim();
    }

    public String getJdimension() {
        return jdimension;
    }

    public void setJdimension(String jdimension) {
        this.jdimension = jdimension == null ? null : jdimension.trim();
    }

    public String getJradius() {
        return jradius;
    }

    public void setJradius(String jradius) {
        this.jradius = jradius == null ? null : jradius.trim();
    }
}