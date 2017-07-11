package com.whimsy.entity;

public class TDeptScope {
    private Integer jId;

    private Integer jDeptid;

    private String jPiont;

    private String jGettime;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getjDeptid() {
        return jDeptid;
    }

    public void setjDeptid(Integer jDeptid) {
        this.jDeptid = jDeptid;
    }

    public String getjPiont() {
        return jPiont;
    }

    public void setjPiont(String jPiont) {
        this.jPiont = jPiont == null ? null : jPiont.trim();
    }

    public String getjGettime() {
        return jGettime;
    }

    public void setjGettime(String jGettime) {
        this.jGettime = jGettime == null ? null : jGettime.trim();
    }
}