package com.whimsy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TGoods {
    private Integer jid;

    private String jgoodscode;

    private String jgoodsname;

    private String jmodel;

    private String junit;

    private String jmemo;

    private Integer jclassid;

    private Integer jsupclientid;

    private String jbarcode;

    private BigDecimal jpointsaleprice;

    private BigDecimal jsale3price;

    private BigDecimal jsale4price;

    private BigDecimal jsale5price;

    private BigDecimal jwholesaleprice;

    private BigDecimal jrefcostprice;

    private BigDecimal jmininprice;

    private BigDecimal jmaxinprice;

    private Integer jmainproductsmark;

    private Boolean jnouse;

    private Integer jauxclassid1;

    private Integer jauxclassid2;

    private Integer jsupplytype;

    private Integer jpurchperiod;

    private Integer jseasonid;

    private Integer jbrandid;

    private String jplace;

    private Integer jsex;

    private String jpycode;

    private BigDecimal jposintegral;

    private BigDecimal jclrprice;

    private String jauthorisationcode;

    private Integer jqualityperiod;

    private Integer juseauxid;

    private BigDecimal jtaxrate;

    private String jdrawingnumber;

    private Integer jweigh;

    private Integer jchangeprice;

    private BigDecimal jretaildiscrate;

    private BigDecimal jsale6price;

    private BigDecimal jsale7price;

    private BigDecimal jjointdisc;

    private BigDecimal jtaxpointsaleprice;

    private BigDecimal jtaxwholesaleprice;

    private BigDecimal jtaxsale3price;

    private BigDecimal jtaxsale4price;

    private BigDecimal jtaxsale5price;

    private BigDecimal jtaxsale6price;

    private BigDecimal jtaxsale7price;

    private Integer jmaterialid;

    private String jsize;

    private Integer jcolorid;

    private Integer jhuajianid;

    private Integer jclassid2;

    private Integer jclassid3;

    private BigDecimal jtotaluseqty;

    private String jmakerule;

    private Integer jshareuse;

    private Integer jeditdeptid;

    private String jgoodsattribute;

    private Date jmodifytime;

    private Integer jattributeid;

    private String jplucode;

    private String jhashcode;

    private Integer jcounterid;

    private BigDecimal jcubage;

    private BigDecimal jweight;

    private Integer jisonsale;

    private Integer jgoodstypeid;

    private BigDecimal jmarketprice;

    private String jlistpicid;

    private String jgoodskeywords;

    private Integer jsalerecord;

    private Integer jvisitrecord;

    private String jdetailname;

    private Integer jpostagetype;

    private Integer jdeliverytype;

    private Integer jdeliverto;

    private Integer jdeliverdate;

    private Integer jpicktime;

    private Integer jnointegral;

    private BigDecimal jservicerate;

    private String jsourceplace;

    private Integer jqualityperiodmonth;

    private String jnetcontent;

    private Date jenddate;

    private String jstoreagemethod;

    private String jpackingmodel;

    private String jburdening;

    private String jnutrientcontent;

    private Boolean jnodisc;

    private Integer jlevelid;

    private BigDecimal jminorderqty;

    private String jcountryunitcode;

    private String jcityunitcode;

    private String jcustomstatusid;

    private Date jpostmartdate;

    private Integer jistop;

    private BigDecimal jmonthsaleqty;

    private Integer jmonthsaleranking;

    private byte[] jphoto;
    
    
    
    private String jbigphoto;
    
    private String jlitphoto;
    
    private String jsubtitle;
    
	private String jphotoscript;
    
    private String jsupclientname;
    
    
    private BigDecimal number;
    
    private BigDecimal goodsmoney;

    public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public BigDecimal getGoodsmoney() {
		return goodsmoney;
	}

	public void setGoodsmoney(BigDecimal goodsmoney) {
		this.goodsmoney = goodsmoney;
	}

	public String getJsubtitle() {
		return jsubtitle;
	}

	public void setJsubtitle(String jsubtitle) {
		this.jsubtitle = jsubtitle;
	}
	
    public String getJsupclientname() {
		return jsupclientname;
	}

	public void setJsupclientname(String jsupclientname) {
		this.jsupclientname = jsupclientname;
	}

	public String getJbigphoto() {
		return jbigphoto;
	}

	public void setJbigphoto(String jbigphoto) {
		this.jbigphoto = jbigphoto;
	}

	public String getJlitphoto() {
		return jlitphoto;
	}

	public void setJlitphoto(String jlitphoto) {
		this.jlitphoto = jlitphoto;
	}

	public String getJphotoscript() {
		return jphotoscript;
	}

	public void setJphotoscript(String jphotoscript) {
		this.jphotoscript = jphotoscript;
	}

	public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJgoodscode() {
        return jgoodscode;
    }

    public void setJgoodscode(String jgoodscode) {
        this.jgoodscode = jgoodscode == null ? null : jgoodscode.trim();
    }

    public String getJgoodsname() {
        return jgoodsname;
    }

    public void setJgoodsname(String jgoodsname) {
        this.jgoodsname = jgoodsname == null ? null : jgoodsname.trim();
    }

    public String getJmodel() {
        return jmodel;
    }

    public void setJmodel(String jmodel) {
        this.jmodel = jmodel == null ? null : jmodel.trim();
    }

    public String getJunit() {
        return junit;
    }

    public void setJunit(String junit) {
        this.junit = junit == null ? null : junit.trim();
    }

    public String getJmemo() {
        return jmemo;
    }

    public void setJmemo(String jmemo) {
        this.jmemo = jmemo == null ? null : jmemo.trim();
    }

    public Integer getJclassid() {
        return jclassid;
    }

    public void setJclassid(Integer jclassid) {
        this.jclassid = jclassid;
    }

    public Integer getJsupclientid() {
        return jsupclientid;
    }

    public void setJsupclientid(Integer jsupclientid) {
        this.jsupclientid = jsupclientid;
    }

    public String getJbarcode() {
        return jbarcode;
    }

    public void setJbarcode(String jbarcode) {
        this.jbarcode = jbarcode == null ? null : jbarcode.trim();
    }

    public BigDecimal getJpointsaleprice() {
        return jpointsaleprice;
    }

    public void setJpointsaleprice(BigDecimal jpointsaleprice) {
        this.jpointsaleprice = jpointsaleprice;
    }

    public BigDecimal getJsale3price() {
        return jsale3price;
    }

    public void setJsale3price(BigDecimal jsale3price) {
        this.jsale3price = jsale3price;
    }

    public BigDecimal getJsale4price() {
        return jsale4price;
    }

    public void setJsale4price(BigDecimal jsale4price) {
        this.jsale4price = jsale4price;
    }

    public BigDecimal getJsale5price() {
        return jsale5price;
    }

    public void setJsale5price(BigDecimal jsale5price) {
        this.jsale5price = jsale5price;
    }

    public BigDecimal getJwholesaleprice() {
        return jwholesaleprice;
    }

    public void setJwholesaleprice(BigDecimal jwholesaleprice) {
        this.jwholesaleprice = jwholesaleprice;
    }

    public BigDecimal getJrefcostprice() {
        return jrefcostprice;
    }

    public void setJrefcostprice(BigDecimal jrefcostprice) {
        this.jrefcostprice = jrefcostprice;
    }

    public BigDecimal getJmininprice() {
        return jmininprice;
    }

    public void setJmininprice(BigDecimal jmininprice) {
        this.jmininprice = jmininprice;
    }

    public BigDecimal getJmaxinprice() {
        return jmaxinprice;
    }

    public void setJmaxinprice(BigDecimal jmaxinprice) {
        this.jmaxinprice = jmaxinprice;
    }

    public Integer getJmainproductsmark() {
        return jmainproductsmark;
    }

    public void setJmainproductsmark(Integer jmainproductsmark) {
        this.jmainproductsmark = jmainproductsmark;
    }

    public Boolean getJnouse() {
        return jnouse;
    }

    public void setJnouse(Boolean jnouse) {
        this.jnouse = jnouse;
    }

    public Integer getJauxclassid1() {
        return jauxclassid1;
    }

    public void setJauxclassid1(Integer jauxclassid1) {
        this.jauxclassid1 = jauxclassid1;
    }

    public Integer getJauxclassid2() {
        return jauxclassid2;
    }

    public void setJauxclassid2(Integer jauxclassid2) {
        this.jauxclassid2 = jauxclassid2;
    }

    public Integer getJsupplytype() {
        return jsupplytype;
    }

    public void setJsupplytype(Integer jsupplytype) {
        this.jsupplytype = jsupplytype;
    }

    public Integer getJpurchperiod() {
        return jpurchperiod;
    }

    public void setJpurchperiod(Integer jpurchperiod) {
        this.jpurchperiod = jpurchperiod;
    }

    public Integer getJseasonid() {
        return jseasonid;
    }

    public void setJseasonid(Integer jseasonid) {
        this.jseasonid = jseasonid;
    }

    public Integer getJbrandid() {
        return jbrandid;
    }

    public void setJbrandid(Integer jbrandid) {
        this.jbrandid = jbrandid;
    }

    public String getJplace() {
        return jplace;
    }

    public void setJplace(String jplace) {
        this.jplace = jplace == null ? null : jplace.trim();
    }

    public Integer getJsex() {
        return jsex;
    }

    public void setJsex(Integer jsex) {
        this.jsex = jsex;
    }

    public String getJpycode() {
        return jpycode;
    }

    public void setJpycode(String jpycode) {
        this.jpycode = jpycode == null ? null : jpycode.trim();
    }

    public BigDecimal getJposintegral() {
        return jposintegral;
    }

    public void setJposintegral(BigDecimal jposintegral) {
        this.jposintegral = jposintegral;
    }

    public BigDecimal getJclrprice() {
        return jclrprice;
    }

    public void setJclrprice(BigDecimal jclrprice) {
        this.jclrprice = jclrprice;
    }

    public String getJauthorisationcode() {
        return jauthorisationcode;
    }

    public void setJauthorisationcode(String jauthorisationcode) {
        this.jauthorisationcode = jauthorisationcode == null ? null : jauthorisationcode.trim();
    }

    public Integer getJqualityperiod() {
        return jqualityperiod;
    }

    public void setJqualityperiod(Integer jqualityperiod) {
        this.jqualityperiod = jqualityperiod;
    }

    public Integer getJuseauxid() {
        return juseauxid;
    }

    public void setJuseauxid(Integer juseauxid) {
        this.juseauxid = juseauxid;
    }

    public BigDecimal getJtaxrate() {
        return jtaxrate;
    }

    public void setJtaxrate(BigDecimal jtaxrate) {
        this.jtaxrate = jtaxrate;
    }

    public String getJdrawingnumber() {
        return jdrawingnumber;
    }

    public void setJdrawingnumber(String jdrawingnumber) {
        this.jdrawingnumber = jdrawingnumber == null ? null : jdrawingnumber.trim();
    }

    public Integer getJweigh() {
        return jweigh;
    }

    public void setJweigh(Integer jweigh) {
        this.jweigh = jweigh;
    }

    public Integer getJchangeprice() {
        return jchangeprice;
    }

    public void setJchangeprice(Integer jchangeprice) {
        this.jchangeprice = jchangeprice;
    }

    public BigDecimal getJretaildiscrate() {
        return jretaildiscrate;
    }

    public void setJretaildiscrate(BigDecimal jretaildiscrate) {
        this.jretaildiscrate = jretaildiscrate;
    }

    public BigDecimal getJsale6price() {
        return jsale6price;
    }

    public void setJsale6price(BigDecimal jsale6price) {
        this.jsale6price = jsale6price;
    }

    public BigDecimal getJsale7price() {
        return jsale7price;
    }

    public void setJsale7price(BigDecimal jsale7price) {
        this.jsale7price = jsale7price;
    }

    public BigDecimal getJjointdisc() {
        return jjointdisc;
    }

    public void setJjointdisc(BigDecimal jjointdisc) {
        this.jjointdisc = jjointdisc;
    }

    public BigDecimal getJtaxpointsaleprice() {
        return jtaxpointsaleprice;
    }

    public void setJtaxpointsaleprice(BigDecimal jtaxpointsaleprice) {
        this.jtaxpointsaleprice = jtaxpointsaleprice;
    }

    public BigDecimal getJtaxwholesaleprice() {
        return jtaxwholesaleprice;
    }

    public void setJtaxwholesaleprice(BigDecimal jtaxwholesaleprice) {
        this.jtaxwholesaleprice = jtaxwholesaleprice;
    }

    public BigDecimal getJtaxsale3price() {
        return jtaxsale3price;
    }

    public void setJtaxsale3price(BigDecimal jtaxsale3price) {
        this.jtaxsale3price = jtaxsale3price;
    }

    public BigDecimal getJtaxsale4price() {
        return jtaxsale4price;
    }

    public void setJtaxsale4price(BigDecimal jtaxsale4price) {
        this.jtaxsale4price = jtaxsale4price;
    }

    public BigDecimal getJtaxsale5price() {
        return jtaxsale5price;
    }

    public void setJtaxsale5price(BigDecimal jtaxsale5price) {
        this.jtaxsale5price = jtaxsale5price;
    }

    public BigDecimal getJtaxsale6price() {
        return jtaxsale6price;
    }

    public void setJtaxsale6price(BigDecimal jtaxsale6price) {
        this.jtaxsale6price = jtaxsale6price;
    }

    public BigDecimal getJtaxsale7price() {
        return jtaxsale7price;
    }

    public void setJtaxsale7price(BigDecimal jtaxsale7price) {
        this.jtaxsale7price = jtaxsale7price;
    }

    public Integer getJmaterialid() {
        return jmaterialid;
    }

    public void setJmaterialid(Integer jmaterialid) {
        this.jmaterialid = jmaterialid;
    }

    public String getJsize() {
        return jsize;
    }

    public void setJsize(String jsize) {
        this.jsize = jsize == null ? null : jsize.trim();
    }

    public Integer getJcolorid() {
        return jcolorid;
    }

    public void setJcolorid(Integer jcolorid) {
        this.jcolorid = jcolorid;
    }

    public Integer getJhuajianid() {
        return jhuajianid;
    }

    public void setJhuajianid(Integer jhuajianid) {
        this.jhuajianid = jhuajianid;
    }

    public Integer getJclassid2() {
        return jclassid2;
    }

    public void setJclassid2(Integer jclassid2) {
        this.jclassid2 = jclassid2;
    }

    public Integer getJclassid3() {
        return jclassid3;
    }

    public void setJclassid3(Integer jclassid3) {
        this.jclassid3 = jclassid3;
    }

    public BigDecimal getJtotaluseqty() {
        return jtotaluseqty;
    }

    public void setJtotaluseqty(BigDecimal jtotaluseqty) {
        this.jtotaluseqty = jtotaluseqty;
    }

    public String getJmakerule() {
        return jmakerule;
    }

    public void setJmakerule(String jmakerule) {
        this.jmakerule = jmakerule == null ? null : jmakerule.trim();
    }

    public Integer getJshareuse() {
        return jshareuse;
    }

    public void setJshareuse(Integer jshareuse) {
        this.jshareuse = jshareuse;
    }

    public Integer getJeditdeptid() {
        return jeditdeptid;
    }

    public void setJeditdeptid(Integer jeditdeptid) {
        this.jeditdeptid = jeditdeptid;
    }

    public String getJgoodsattribute() {
        return jgoodsattribute;
    }

    public void setJgoodsattribute(String jgoodsattribute) {
        this.jgoodsattribute = jgoodsattribute == null ? null : jgoodsattribute.trim();
    }

    public Date getJmodifytime() {
        return jmodifytime;
    }

    public void setJmodifytime(Date jmodifytime) {
        this.jmodifytime = jmodifytime;
    }

    public Integer getJattributeid() {
        return jattributeid;
    }

    public void setJattributeid(Integer jattributeid) {
        this.jattributeid = jattributeid;
    }

    public String getJplucode() {
        return jplucode;
    }

    public void setJplucode(String jplucode) {
        this.jplucode = jplucode == null ? null : jplucode.trim();
    }

    public String getJhashcode() {
        return jhashcode;
    }

    public void setJhashcode(String jhashcode) {
        this.jhashcode = jhashcode == null ? null : jhashcode.trim();
    }

    public Integer getJcounterid() {
        return jcounterid;
    }

    public void setJcounterid(Integer jcounterid) {
        this.jcounterid = jcounterid;
    }

    public BigDecimal getJcubage() {
        return jcubage;
    }

    public void setJcubage(BigDecimal jcubage) {
        this.jcubage = jcubage;
    }

    public BigDecimal getJweight() {
        return jweight;
    }

    public void setJweight(BigDecimal jweight) {
        this.jweight = jweight;
    }

    public Integer getJisonsale() {
        return jisonsale;
    }

    public void setJisonsale(Integer jisonsale) {
        this.jisonsale = jisonsale;
    }

    public Integer getJgoodstypeid() {
        return jgoodstypeid;
    }

    public void setJgoodstypeid(Integer jgoodstypeid) {
        this.jgoodstypeid = jgoodstypeid;
    }

    public BigDecimal getJmarketprice() {
        return jmarketprice;
    }

    public void setJmarketprice(BigDecimal jmarketprice) {
        this.jmarketprice = jmarketprice;
    }

    public String getJlistpicid() {
        return jlistpicid;
    }

    public void setJlistpicid(String jlistpicid) {
        this.jlistpicid = jlistpicid == null ? null : jlistpicid.trim();
    }

    public String getJgoodskeywords() {
        return jgoodskeywords;
    }

    public void setJgoodskeywords(String jgoodskeywords) {
        this.jgoodskeywords = jgoodskeywords == null ? null : jgoodskeywords.trim();
    }

    public Integer getJsalerecord() {
        return jsalerecord;
    }

    public void setJsalerecord(Integer jsalerecord) {
        this.jsalerecord = jsalerecord;
    }

    public Integer getJvisitrecord() {
        return jvisitrecord;
    }

    public void setJvisitrecord(Integer jvisitrecord) {
        this.jvisitrecord = jvisitrecord;
    }

    public String getJdetailname() {
        return jdetailname;
    }

    public void setJdetailname(String jdetailname) {
        this.jdetailname = jdetailname == null ? null : jdetailname.trim();
    }

    public Integer getJpostagetype() {
        return jpostagetype;
    }

    public void setJpostagetype(Integer jpostagetype) {
        this.jpostagetype = jpostagetype;
    }

    public Integer getJdeliverytype() {
        return jdeliverytype;
    }

    public void setJdeliverytype(Integer jdeliverytype) {
        this.jdeliverytype = jdeliverytype;
    }

    public Integer getJdeliverto() {
        return jdeliverto;
    }

    public void setJdeliverto(Integer jdeliverto) {
        this.jdeliverto = jdeliverto;
    }

    public Integer getJdeliverdate() {
        return jdeliverdate;
    }

    public void setJdeliverdate(Integer jdeliverdate) {
        this.jdeliverdate = jdeliverdate;
    }

    public Integer getJpicktime() {
        return jpicktime;
    }

    public void setJpicktime(Integer jpicktime) {
        this.jpicktime = jpicktime;
    }

    public Integer getJnointegral() {
        return jnointegral;
    }

    public void setJnointegral(Integer jnointegral) {
        this.jnointegral = jnointegral;
    }

    public BigDecimal getJservicerate() {
        return jservicerate;
    }

    public void setJservicerate(BigDecimal jservicerate) {
        this.jservicerate = jservicerate;
    }

    public String getJsourceplace() {
        return jsourceplace;
    }

    public void setJsourceplace(String jsourceplace) {
        this.jsourceplace = jsourceplace == null ? null : jsourceplace.trim();
    }

    public Integer getJqualityperiodmonth() {
        return jqualityperiodmonth;
    }

    public void setJqualityperiodmonth(Integer jqualityperiodmonth) {
        this.jqualityperiodmonth = jqualityperiodmonth;
    }

    public String getJnetcontent() {
        return jnetcontent;
    }

    public void setJnetcontent(String jnetcontent) {
        this.jnetcontent = jnetcontent == null ? null : jnetcontent.trim();
    }

    public Date getJenddate() {
        return jenddate;
    }

    public void setJenddate(Date jenddate) {
        this.jenddate = jenddate;
    }

    public String getJstoreagemethod() {
        return jstoreagemethod;
    }

    public void setJstoreagemethod(String jstoreagemethod) {
        this.jstoreagemethod = jstoreagemethod == null ? null : jstoreagemethod.trim();
    }

    public String getJpackingmodel() {
        return jpackingmodel;
    }

    public void setJpackingmodel(String jpackingmodel) {
        this.jpackingmodel = jpackingmodel == null ? null : jpackingmodel.trim();
    }

    public String getJburdening() {
        return jburdening;
    }

    public void setJburdening(String jburdening) {
        this.jburdening = jburdening == null ? null : jburdening.trim();
    }

    public String getJnutrientcontent() {
        return jnutrientcontent;
    }

    public void setJnutrientcontent(String jnutrientcontent) {
        this.jnutrientcontent = jnutrientcontent == null ? null : jnutrientcontent.trim();
    }

    public Boolean getJnodisc() {
        return jnodisc;
    }

    public void setJnodisc(Boolean jnodisc) {
        this.jnodisc = jnodisc;
    }

    public Integer getJlevelid() {
        return jlevelid;
    }

    public void setJlevelid(Integer jlevelid) {
        this.jlevelid = jlevelid;
    }

    public BigDecimal getJminorderqty() {
        return jminorderqty;
    }

    public void setJminorderqty(BigDecimal jminorderqty) {
        this.jminorderqty = jminorderqty;
    }

    public String getJcountryunitcode() {
        return jcountryunitcode;
    }

    public void setJcountryunitcode(String jcountryunitcode) {
        this.jcountryunitcode = jcountryunitcode == null ? null : jcountryunitcode.trim();
    }

    public String getJcityunitcode() {
        return jcityunitcode;
    }

    public void setJcityunitcode(String jcityunitcode) {
        this.jcityunitcode = jcityunitcode == null ? null : jcityunitcode.trim();
    }

    public String getJcustomstatusid() {
        return jcustomstatusid;
    }

    public void setJcustomstatusid(String jcustomstatusid) {
        this.jcustomstatusid = jcustomstatusid == null ? null : jcustomstatusid.trim();
    }

    public Date getJpostmartdate() {
        return jpostmartdate;
    }

    public void setJpostmartdate(Date jpostmartdate) {
        this.jpostmartdate = jpostmartdate;
    }

    public Integer getJistop() {
        return jistop;
    }

    public void setJistop(Integer jistop) {
        this.jistop = jistop;
    }

    public BigDecimal getJmonthsaleqty() {
        return jmonthsaleqty;
    }

    public void setJmonthsaleqty(BigDecimal jmonthsaleqty) {
        this.jmonthsaleqty = jmonthsaleqty;
    }

    public Integer getJmonthsaleranking() {
        return jmonthsaleranking;
    }

    public void setJmonthsaleranking(Integer jmonthsaleranking) {
        this.jmonthsaleranking = jmonthsaleranking;
    }

    public byte[] getJphoto() {
        return jphoto;
    }

    public void setJphoto(byte[] jphoto) {
        this.jphoto = jphoto;
    }
}