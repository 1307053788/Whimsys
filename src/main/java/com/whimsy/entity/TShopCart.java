package com.whimsy.entity;

import java.math.BigDecimal;

public class TShopCart {
    private Integer jId;

    private Integer jDepartmentId;

    private Integer jMembercardId;
    
    private Integer jGoodsId;

	private Integer jNumber;
	
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
    
    private byte[] jphoto;
    
    
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

	public BigDecimal getJactprice() {
		return jactprice;
	}

	public void setJactprice(BigDecimal jactprice) {
		this.jactprice = jactprice;
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

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
		this.jId = jId;
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

	public byte[] getJphoto() {
		return jphoto;
	}

	public void setJphoto(byte[] jphoto) {
		this.jphoto = jphoto;
	}

	public Integer getjDepartmentId() {
		return jDepartmentId;
	}

	public void setjDepartmentId(Integer jDepartmentId) {
		this.jDepartmentId = jDepartmentId;
	}

	public Integer getjMembercardId() {
		return jMembercardId;
	}

	public void setjMembercardId(Integer jMembercardId) {
		this.jMembercardId = jMembercardId;
	}

    public Integer getjNumber() {
        return jNumber;
    }

    public void setjNumber(Integer jNumber) {
        this.jNumber = jNumber;
    }
    
    public Integer getjGoodsId() {
		return jGoodsId;
	}

	public void setjGoodsId(Integer jGoodsId) {
		this.jGoodsId = jGoodsId;
	}
}