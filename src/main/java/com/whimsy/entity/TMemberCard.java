package com.whimsy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TMemberCard {
    private Integer jid;

    private Integer jdeptid;

    private String jempcode;

    private String jempname;

    private Boolean jcustomsex;

    private String jtele;

    private String jcustomaddress;

    private String jidentitycode;

    private Boolean jnouse;

    private Integer jdiscid;

    private BigDecimal jdiscrate;

    private Integer jcardclassid;

    private BigDecimal jcustomamt;

    private BigDecimal jcurrentinqty;

    private BigDecimal jcurrentoutqty;

    private BigDecimal jendqty;

    private String jemail;

    private Integer jsizeid;

    private Date jbirthday;

    private Integer jmemparentid;

    private String jmobilenumber;

    private Date jsendoutdaten;

    private BigDecimal jopenqty;

    private BigDecimal jopenfillamt;

    private BigDecimal jinfillqty;

    private BigDecimal jinfillamt;

    private BigDecimal joutfillqty;

    private BigDecimal joutfillamt;

    private BigDecimal jendfillamt;

    private Boolean jfillid;

    private String jpassword;

    private Date jbuilddate;

    private String jbuildbatchcode;

    private Integer jinputrid;

    private Integer jchkrid;

    private Date jchkdate;

    private Integer jstateid;

    private Integer jcardtype;

    private Date jbegindate;

    private Date jenddate;

    private Integer jbuilddeptid;

    private Integer jbuilduserid;

    private Date jsendoutdate;

    private Integer jhandleid;

    private String jmemo;

    private Integer jsupclientid;

    private Integer joldcardid;

    private String jcountrycode;

    private String jprovincecode;

    private String jcitycode;

    private String jcountycode;

    private String jmetiercode;

    private String jworkcompany;

    private String jcontractaddress;

    private String jpostalcode;

    private Integer jbirthdayid;

    private String jqqnumber;

    private String jmsnnumber;

    private BigDecimal jstature;

    private BigDecimal javoirdupois;

    private Integer jbloodtype;

    private Integer jconstellation;

    private Integer jmarriagestate;

    private String jlove;

    private String jtabu;

    private Integer jyearincomeid;

    private Integer jskincharid;

    private Integer jskinmatterid;

    private String jexplain;

    private BigDecimal jyearconsumeamt;

    private Integer jconsumecount;

    private String jcustomfield1;

    private String jcustomfield2;

    private String jcustomfield3;

    private String jcustomfield4;

    private String jcustomfield5;

    private String jcustomfield6;

    private String jcustomfield7;

    private String jcustomfield8;

    private String jcustomfield9;

    private String jconsigneename;

    private String jconsigneeaddress;

    private String jconsigneetele;

    private Date jmodifytime;

    private String jbankname;

    private String jaccount;

    private String jalipayaccount;

    private String jdeliverypwd;

    private Integer jcountrycityid;

    private String jbank;

    private String jloginname;

    private Integer jbindaccountstate;

    private String jwechat;

    private String jopenid;

    private Integer jmenberlocalid;

    private String jbinddelivery;

    private String jportrait;

    private String jtoken;
    
    private String jifsign;
    
    private String jsigndata;
    
    private BigDecimal jcouponcount;

    public BigDecimal getJcouponcount() {
		return jcouponcount;
	}

	public void setJcouponcount(BigDecimal bigDecimal) {
		this.jcouponcount = bigDecimal;
	}

	public String getJsigndata() {
		return jsigndata;
	}

	public void setJsigndata(String jsigndata) {
		this.jsigndata = jsigndata;
	}

	public String getJifsign() {
		return jifsign;
	}

	public void setJifsign(String jifsign) {
		this.jifsign = jifsign;
	}

	private byte[] jexcelinfo;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getJdeptid() {
        return jdeptid;
    }

    public void setJdeptid(Integer jdeptid) {
        this.jdeptid = jdeptid;
    }

    public String getJempcode() {
        return jempcode;
    }

    public void setJempcode(String jempcode) {
        this.jempcode = jempcode == null ? null : jempcode.trim();
    }

    public String getJempname() {
        return jempname;
    }

    public void setJempname(String jempname) {
        this.jempname = jempname == null ? null : jempname.trim();
    }

    public Boolean getJcustomsex() {
        return jcustomsex;
    }

    public void setJcustomsex(Boolean jcustomsex) {
        this.jcustomsex = jcustomsex;
    }

    public String getJtele() {
        return jtele;
    }

    public void setJtele(String jtele) {
        this.jtele = jtele == null ? null : jtele.trim();
    }

    public String getJcustomaddress() {
        return jcustomaddress;
    }

    public void setJcustomaddress(String jcustomaddress) {
        this.jcustomaddress = jcustomaddress == null ? null : jcustomaddress.trim();
    }

    public String getJidentitycode() {
        return jidentitycode;
    }

    public void setJidentitycode(String jidentitycode) {
        this.jidentitycode = jidentitycode == null ? null : jidentitycode.trim();
    }

    public Boolean getJnouse() {
        return jnouse;
    }

    public void setJnouse(Boolean jnouse) {
        this.jnouse = jnouse;
    }

    public Integer getJdiscid() {
        return jdiscid;
    }

    public void setJdiscid(Integer jdiscid) {
        this.jdiscid = jdiscid;
    }

    public BigDecimal getJdiscrate() {
        return jdiscrate;
    }

    public void setJdiscrate(BigDecimal jdiscrate) {
        this.jdiscrate = jdiscrate;
    }

    public Integer getJcardclassid() {
        return jcardclassid;
    }

    public void setJcardclassid(Integer jcardclassid) {
        this.jcardclassid = jcardclassid;
    }

    public BigDecimal getJcustomamt() {
        return jcustomamt;
    }

    public void setJcustomamt(BigDecimal jcustomamt) {
        this.jcustomamt = jcustomamt;
    }

    public BigDecimal getJcurrentinqty() {
        return jcurrentinqty;
    }

    public void setJcurrentinqty(BigDecimal jcurrentinqty) {
        this.jcurrentinqty = jcurrentinqty;
    }

    public BigDecimal getJcurrentoutqty() {
        return jcurrentoutqty;
    }

    public void setJcurrentoutqty(BigDecimal jcurrentoutqty) {
        this.jcurrentoutqty = jcurrentoutqty;
    }

    public BigDecimal getJendqty() {
        return jendqty;
    }

    public void setJendqty(BigDecimal jendqty) {
        this.jendqty = jendqty;
    }

    public String getJemail() {
        return jemail;
    }

    public void setJemail(String jemail) {
        this.jemail = jemail == null ? null : jemail.trim();
    }

    public Integer getJsizeid() {
        return jsizeid;
    }

    public void setJsizeid(Integer jsizeid) {
        this.jsizeid = jsizeid;
    }

    public Date getJbirthday() {
        return jbirthday;
    }

    public void setJbirthday(Date jbirthday) {
        this.jbirthday = jbirthday;
    }

    public Integer getJmemparentid() {
        return jmemparentid;
    }

    public void setJmemparentid(Integer jmemparentid) {
        this.jmemparentid = jmemparentid;
    }

    public String getJmobilenumber() {
        return jmobilenumber;
    }

    public void setJmobilenumber(String jmobilenumber) {
        this.jmobilenumber = jmobilenumber == null ? null : jmobilenumber.trim();
    }

    public Date getJsendoutdaten() {
        return jsendoutdaten;
    }

    public void setJsendoutdaten(Date jsendoutdaten) {
        this.jsendoutdaten = jsendoutdaten;
    }

    public BigDecimal getJopenqty() {
        return jopenqty;
    }

    public void setJopenqty(BigDecimal jopenqty) {
        this.jopenqty = jopenqty;
    }

    public BigDecimal getJopenfillamt() {
        return jopenfillamt;
    }

    public void setJopenfillamt(BigDecimal jopenfillamt) {
        this.jopenfillamt = jopenfillamt;
    }

    public BigDecimal getJinfillqty() {
        return jinfillqty;
    }

    public void setJinfillqty(BigDecimal jinfillqty) {
        this.jinfillqty = jinfillqty;
    }

    public BigDecimal getJinfillamt() {
        return jinfillamt;
    }

    public void setJinfillamt(BigDecimal jinfillamt) {
        this.jinfillamt = jinfillamt;
    }

    public BigDecimal getJoutfillqty() {
        return joutfillqty;
    }

    public void setJoutfillqty(BigDecimal joutfillqty) {
        this.joutfillqty = joutfillqty;
    }

    public BigDecimal getJoutfillamt() {
        return joutfillamt;
    }

    public void setJoutfillamt(BigDecimal joutfillamt) {
        this.joutfillamt = joutfillamt;
    }

    public BigDecimal getJendfillamt() {
        return jendfillamt;
    }

    public void setJendfillamt(BigDecimal jendfillamt) {
        this.jendfillamt = jendfillamt;
    }

    public Boolean getJfillid() {
        return jfillid;
    }

    public void setJfillid(Boolean jfillid) {
        this.jfillid = jfillid;
    }

    public String getJpassword() {
        return jpassword;
    }

    public void setJpassword(String jpassword) {
        this.jpassword = jpassword == null ? null : jpassword.trim();
    }

    public Date getJbuilddate() {
        return jbuilddate;
    }

    public void setJbuilddate(Date jbuilddate) {
        this.jbuilddate = jbuilddate;
    }

    public String getJbuildbatchcode() {
        return jbuildbatchcode;
    }

    public void setJbuildbatchcode(String jbuildbatchcode) {
        this.jbuildbatchcode = jbuildbatchcode == null ? null : jbuildbatchcode.trim();
    }

    public Integer getJinputrid() {
        return jinputrid;
    }

    public void setJinputrid(Integer jinputrid) {
        this.jinputrid = jinputrid;
    }

    public Integer getJchkrid() {
        return jchkrid;
    }

    public void setJchkrid(Integer jchkrid) {
        this.jchkrid = jchkrid;
    }

    public Date getJchkdate() {
        return jchkdate;
    }

    public void setJchkdate(Date jchkdate) {
        this.jchkdate = jchkdate;
    }

    public Integer getJstateid() {
        return jstateid;
    }

    public void setJstateid(Integer jstateid) {
        this.jstateid = jstateid;
    }

    public Integer getJcardtype() {
        return jcardtype;
    }

    public void setJcardtype(Integer jcardtype) {
        this.jcardtype = jcardtype;
    }

    public Date getJbegindate() {
        return jbegindate;
    }

    public void setJbegindate(Date jbegindate) {
        this.jbegindate = jbegindate;
    }

    public Date getJenddate() {
        return jenddate;
    }

    public void setJenddate(Date jenddate) {
        this.jenddate = jenddate;
    }

    public Integer getJbuilddeptid() {
        return jbuilddeptid;
    }

    public void setJbuilddeptid(Integer jbuilddeptid) {
        this.jbuilddeptid = jbuilddeptid;
    }

    public Integer getJbuilduserid() {
        return jbuilduserid;
    }

    public void setJbuilduserid(Integer jbuilduserid) {
        this.jbuilduserid = jbuilduserid;
    }

    public Date getJsendoutdate() {
        return jsendoutdate;
    }

    public void setJsendoutdate(Date jsendoutdate) {
        this.jsendoutdate = jsendoutdate;
    }

    public Integer getJhandleid() {
        return jhandleid;
    }

    public void setJhandleid(Integer jhandleid) {
        this.jhandleid = jhandleid;
    }

    public String getJmemo() {
        return jmemo;
    }

    public void setJmemo(String jmemo) {
        this.jmemo = jmemo == null ? null : jmemo.trim();
    }

    public Integer getJsupclientid() {
        return jsupclientid;
    }

    public void setJsupclientid(Integer jsupclientid) {
        this.jsupclientid = jsupclientid;
    }

    public Integer getJoldcardid() {
        return joldcardid;
    }

    public void setJoldcardid(Integer joldcardid) {
        this.joldcardid = joldcardid;
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

    public String getJmetiercode() {
        return jmetiercode;
    }

    public void setJmetiercode(String jmetiercode) {
        this.jmetiercode = jmetiercode == null ? null : jmetiercode.trim();
    }

    public String getJworkcompany() {
        return jworkcompany;
    }

    public void setJworkcompany(String jworkcompany) {
        this.jworkcompany = jworkcompany == null ? null : jworkcompany.trim();
    }

    public String getJcontractaddress() {
        return jcontractaddress;
    }

    public void setJcontractaddress(String jcontractaddress) {
        this.jcontractaddress = jcontractaddress == null ? null : jcontractaddress.trim();
    }

    public String getJpostalcode() {
        return jpostalcode;
    }

    public void setJpostalcode(String jpostalcode) {
        this.jpostalcode = jpostalcode == null ? null : jpostalcode.trim();
    }

    public Integer getJbirthdayid() {
        return jbirthdayid;
    }

    public void setJbirthdayid(Integer jbirthdayid) {
        this.jbirthdayid = jbirthdayid;
    }

    public String getJqqnumber() {
        return jqqnumber;
    }

    public void setJqqnumber(String jqqnumber) {
        this.jqqnumber = jqqnumber == null ? null : jqqnumber.trim();
    }

    public String getJmsnnumber() {
        return jmsnnumber;
    }

    public void setJmsnnumber(String jmsnnumber) {
        this.jmsnnumber = jmsnnumber == null ? null : jmsnnumber.trim();
    }

    public BigDecimal getJstature() {
        return jstature;
    }

    public void setJstature(BigDecimal jstature) {
        this.jstature = jstature;
    }

    public BigDecimal getJavoirdupois() {
        return javoirdupois;
    }

    public void setJavoirdupois(BigDecimal javoirdupois) {
        this.javoirdupois = javoirdupois;
    }

    public Integer getJbloodtype() {
        return jbloodtype;
    }

    public void setJbloodtype(Integer jbloodtype) {
        this.jbloodtype = jbloodtype;
    }

    public Integer getJconstellation() {
        return jconstellation;
    }

    public void setJconstellation(Integer jconstellation) {
        this.jconstellation = jconstellation;
    }

    public Integer getJmarriagestate() {
        return jmarriagestate;
    }

    public void setJmarriagestate(Integer jmarriagestate) {
        this.jmarriagestate = jmarriagestate;
    }

    public String getJlove() {
        return jlove;
    }

    public void setJlove(String jlove) {
        this.jlove = jlove == null ? null : jlove.trim();
    }

    public String getJtabu() {
        return jtabu;
    }

    public void setJtabu(String jtabu) {
        this.jtabu = jtabu == null ? null : jtabu.trim();
    }

    public Integer getJyearincomeid() {
        return jyearincomeid;
    }

    public void setJyearincomeid(Integer jyearincomeid) {
        this.jyearincomeid = jyearincomeid;
    }

    public Integer getJskincharid() {
        return jskincharid;
    }

    public void setJskincharid(Integer jskincharid) {
        this.jskincharid = jskincharid;
    }

    public Integer getJskinmatterid() {
        return jskinmatterid;
    }

    public void setJskinmatterid(Integer jskinmatterid) {
        this.jskinmatterid = jskinmatterid;
    }

    public String getJexplain() {
        return jexplain;
    }

    public void setJexplain(String jexplain) {
        this.jexplain = jexplain == null ? null : jexplain.trim();
    }

    public BigDecimal getJyearconsumeamt() {
        return jyearconsumeamt;
    }

    public void setJyearconsumeamt(BigDecimal jyearconsumeamt) {
        this.jyearconsumeamt = jyearconsumeamt;
    }

    public Integer getJconsumecount() {
        return jconsumecount;
    }

    public void setJconsumecount(Integer jconsumecount) {
        this.jconsumecount = jconsumecount;
    }

    public String getJcustomfield1() {
        return jcustomfield1;
    }

    public void setJcustomfield1(String jcustomfield1) {
        this.jcustomfield1 = jcustomfield1 == null ? null : jcustomfield1.trim();
    }

    public String getJcustomfield2() {
        return jcustomfield2;
    }

    public void setJcustomfield2(String jcustomfield2) {
        this.jcustomfield2 = jcustomfield2 == null ? null : jcustomfield2.trim();
    }

    public String getJcustomfield3() {
        return jcustomfield3;
    }

    public void setJcustomfield3(String jcustomfield3) {
        this.jcustomfield3 = jcustomfield3 == null ? null : jcustomfield3.trim();
    }

    public String getJcustomfield4() {
        return jcustomfield4;
    }

    public void setJcustomfield4(String jcustomfield4) {
        this.jcustomfield4 = jcustomfield4 == null ? null : jcustomfield4.trim();
    }

    public String getJcustomfield5() {
        return jcustomfield5;
    }

    public void setJcustomfield5(String jcustomfield5) {
        this.jcustomfield5 = jcustomfield5 == null ? null : jcustomfield5.trim();
    }

    public String getJcustomfield6() {
        return jcustomfield6;
    }

    public void setJcustomfield6(String jcustomfield6) {
        this.jcustomfield6 = jcustomfield6 == null ? null : jcustomfield6.trim();
    }

    public String getJcustomfield7() {
        return jcustomfield7;
    }

    public void setJcustomfield7(String jcustomfield7) {
        this.jcustomfield7 = jcustomfield7 == null ? null : jcustomfield7.trim();
    }

    public String getJcustomfield8() {
        return jcustomfield8;
    }

    public void setJcustomfield8(String jcustomfield8) {
        this.jcustomfield8 = jcustomfield8 == null ? null : jcustomfield8.trim();
    }

    public String getJcustomfield9() {
        return jcustomfield9;
    }

    public void setJcustomfield9(String jcustomfield9) {
        this.jcustomfield9 = jcustomfield9 == null ? null : jcustomfield9.trim();
    }

    public String getJconsigneename() {
        return jconsigneename;
    }

    public void setJconsigneename(String jconsigneename) {
        this.jconsigneename = jconsigneename == null ? null : jconsigneename.trim();
    }

    public String getJconsigneeaddress() {
        return jconsigneeaddress;
    }

    public void setJconsigneeaddress(String jconsigneeaddress) {
        this.jconsigneeaddress = jconsigneeaddress == null ? null : jconsigneeaddress.trim();
    }

    public String getJconsigneetele() {
        return jconsigneetele;
    }

    public void setJconsigneetele(String jconsigneetele) {
        this.jconsigneetele = jconsigneetele == null ? null : jconsigneetele.trim();
    }

    public Date getJmodifytime() {
        return jmodifytime;
    }

    public void setJmodifytime(Date jmodifytime) {
        this.jmodifytime = jmodifytime;
    }

    public String getJbankname() {
        return jbankname;
    }

    public void setJbankname(String jbankname) {
        this.jbankname = jbankname == null ? null : jbankname.trim();
    }

    public String getJaccount() {
        return jaccount;
    }

    public void setJaccount(String jaccount) {
        this.jaccount = jaccount == null ? null : jaccount.trim();
    }

    public String getJalipayaccount() {
        return jalipayaccount;
    }

    public void setJalipayaccount(String jalipayaccount) {
        this.jalipayaccount = jalipayaccount == null ? null : jalipayaccount.trim();
    }

    public String getJdeliverypwd() {
        return jdeliverypwd;
    }

    public void setJdeliverypwd(String jdeliverypwd) {
        this.jdeliverypwd = jdeliverypwd == null ? null : jdeliverypwd.trim();
    }

    public Integer getJcountrycityid() {
        return jcountrycityid;
    }

    public void setJcountrycityid(Integer jcountrycityid) {
        this.jcountrycityid = jcountrycityid;
    }

    public String getJbank() {
        return jbank;
    }

    public void setJbank(String jbank) {
        this.jbank = jbank == null ? null : jbank.trim();
    }

    public String getJloginname() {
        return jloginname;
    }

    public void setJloginname(String jloginname) {
        this.jloginname = jloginname == null ? null : jloginname.trim();
    }

    public Integer getJbindaccountstate() {
        return jbindaccountstate;
    }

    public void setJbindaccountstate(Integer jbindaccountstate) {
        this.jbindaccountstate = jbindaccountstate;
    }

    public String getJwechat() {
        return jwechat;
    }

    public void setJwechat(String jwechat) {
        this.jwechat = jwechat == null ? null : jwechat.trim();
    }

    public String getJopenid() {
        return jopenid;
    }

    public void setJopenid(String jopenid) {
        this.jopenid = jopenid == null ? null : jopenid.trim();
    }

    public Integer getJmenberlocalid() {
        return jmenberlocalid;
    }

    public void setJmenberlocalid(Integer jmenberlocalid) {
        this.jmenberlocalid = jmenberlocalid;
    }

    public String getJbinddelivery() {
        return jbinddelivery;
    }

    public void setJbinddelivery(String jbinddelivery) {
        this.jbinddelivery = jbinddelivery == null ? null : jbinddelivery.trim();
    }

    public String getJportrait() {
        return jportrait;
    }

    public void setJportrait(String jportrait) {
        this.jportrait = jportrait == null ? null : jportrait.trim();
    }

    public String getJtoken() {
        return jtoken;
    }

    public void setJtoken(String jtoken) {
        this.jtoken = jtoken == null ? null : jtoken.trim();
    }

    public byte[] getJexcelinfo() {
        return jexcelinfo;
    }

    public void setJexcelinfo(byte[] jexcelinfo) {
        this.jexcelinfo = jexcelinfo;
    }
}