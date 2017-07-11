package com.whimsy.entity;

import java.math.BigDecimal;

public class TActivity {
    private Integer jId;

    private String jTitle;

    private String jPhoto;

    private String jDiscription;

    private String jType;

    private Integer jDeptId;
    
    
    private Integer jgoodsid;
    
    private BigDecimal jstockqty;
    
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
    
    private BigDecimal jrefcostprice;

    private BigDecimal jmininprice;
    
    private String jplace;
    
    
    private String jbigphoto;
    
	private String jlitphoto;
    
    private String jsubtitle;
    
    
    private BigDecimal jdiscount;
    private BigDecimal jactprice;
    
    public BigDecimal getJdiscount() {
		return jdiscount;
	}

	public void setJdiscount(BigDecimal jdiscount) {
		this.jdiscount = jdiscount;
	}


    public BigDecimal getJstockqty() {
		return jstockqty;
	}

	public void setJstockqty(BigDecimal jstockqty) {
		this.jstockqty = jstockqty;
	}

	public String getJgoodscode() {
		return jgoodscode;
	}

	public void setJgoodscode(String jgoodscode) {
		this.jgoodscode = jgoodscode;
	}

	public String getJgoodsname() {
		return jgoodsname;
	}

	public void setJgoodsname(String jgoodsname) {
		this.jgoodsname = jgoodsname;
	}

	public String getJmodel() {
		return jmodel;
	}

	public void setJmodel(String jmodel) {
		this.jmodel = jmodel;
	}

	public String getJunit() {
		return junit;
	}

	public void setJunit(String junit) {
		this.junit = junit;
	}

	public String getJmemo() {
		return jmemo;
	}

	public void setJmemo(String jmemo) {
		this.jmemo = jmemo;
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
		this.jbarcode = jbarcode;
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

	public String getJplace() {
		return jplace;
	}

	public void setJplace(String jplace) {
		this.jplace = jplace;
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

	public String getJsubtitle() {
		return jsubtitle;
	}

	public void setJsubtitle(String jsubtitle) {
		this.jsubtitle = jsubtitle;
	}

	public BigDecimal getJactprice() {
		return jactprice;
	}

	public void setJactprice(BigDecimal jactprice) {
		this.jactprice = jactprice;
	}

	public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjTitle() {
        return jTitle;
    }

    public void setjTitle(String jTitle) {
        this.jTitle = jTitle == null ? null : jTitle.trim();
    }

    public String getjPhoto() {
        return jPhoto;
    }

    public void setjPhoto(String jPhoto) {
        this.jPhoto = jPhoto == null ? null : jPhoto.trim();
    }

    public String getjDiscription() {
        return jDiscription;
    }

    public void setjDiscription(String jDiscription) {
        this.jDiscription = jDiscription == null ? null : jDiscription.trim();
    }

    public String getjType() {
        return jType;
    }

    public void setjType(String jType) {
        this.jType = jType == null ? null : jType.trim();
    }

    public Integer getjDeptId() {
        return jDeptId;
    }

    public void setjDeptId(Integer jDeptId) {
        this.jDeptId = jDeptId;
    }
    
    public Integer getJgoodsid() {
		return jgoodsid;
	}

	public void setJgoodsid(Integer jgoodsid) {
		this.jgoodsid = jgoodsid;
	}
}