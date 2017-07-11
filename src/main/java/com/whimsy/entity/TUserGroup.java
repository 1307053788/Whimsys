package com.whimsy.entity;

public class TUserGroup {
    private Integer jid;

    private String jgroupname;

    private Integer jparentgroupid;

    private Integer jidentityid;

    private String jremark;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJgroupname() {
        return jgroupname;
    }

    public void setJgroupname(String jgroupname) {
        this.jgroupname = jgroupname == null ? null : jgroupname.trim();
    }

    public Integer getJparentgroupid() {
        return jparentgroupid;
    }

    public void setJparentgroupid(Integer jparentgroupid) {
        this.jparentgroupid = jparentgroupid;
    }

    public Integer getJidentityid() {
        return jidentityid;
    }

    public void setJidentityid(Integer jidentityid) {
        this.jidentityid = jidentityid;
    }

    public String getJremark() {
        return jremark;
    }

    public void setJremark(String jremark) {
        this.jremark = jremark == null ? null : jremark.trim();
    }
}