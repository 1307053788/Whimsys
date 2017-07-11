package com.whimsy.entity;

public class TTwoKind {
    private Integer jId;

    private String jCode;

    private String jName;

    private Integer jParentId;

    private String jDescription;

    private Integer jDepartmentId;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjCode() {
        return jCode;
    }

    public void setjCode(String jCode) {
        this.jCode = jCode == null ? null : jCode.trim();
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName == null ? null : jName.trim();
    }

    public Integer getjParentId() {
        return jParentId;
    }

    public void setjParentId(Integer jParentId) {
        this.jParentId = jParentId;
    }

    public String getjDescription() {
        return jDescription;
    }

    public void setjDescription(String jDescription) {
        this.jDescription = jDescription == null ? null : jDescription.trim();
    }

    public Integer getjDepartmentId() {
        return jDepartmentId;
    }

    public void setjDepartmentId(Integer jDepartmentId) {
        this.jDepartmentId = jDepartmentId;
    }
}