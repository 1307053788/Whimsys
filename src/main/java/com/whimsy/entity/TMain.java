package com.whimsy.entity;

public class TMain {
    private Integer jId;

    private Integer jType;

    private Integer jArra;

    private Integer jPid;
    
    private Integer jDeptId;

	private String jPhoto;
	
	private String jKeyword;

	public String getjPhoto() {
		return jPhoto;
	}

	public void setjPhoto(String jPhoto) {
		this.jPhoto = jPhoto;
	}

	public String getjKeyword() {
		return jKeyword;
	}

	public void setjKeyword(String jKeyword) {
		this.jKeyword = jKeyword;
	}

	public Integer getjDeptId() {
		return jDeptId;
	}

	public void setjDeptId(Integer jDeptId) {
		this.jDeptId = jDeptId;
	}
	
    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getjType() {
        return jType;
    }

    public void setjType(Integer jType) {
        this.jType = jType;
    }

    public Integer getjArra() {
        return jArra;
    }

    public void setjArra(Integer jArra) {
        this.jArra = jArra;
    }

    public Integer getjPid() {
        return jPid;
    }

    public void setjPid(Integer jPid) {
        this.jPid = jPid;
    }

    public String getjPhone() {
        return jPhoto;
    }

    public void setjPhone(String jPhone) {
        this.jPhoto = jPhone == null ? null : jPhone.trim();
    }
}