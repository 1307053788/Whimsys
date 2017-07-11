package com.whimsy.entity;

public class TMsgCode {
    private String jPhone;

	private String jCode;

	private String jData;

	public String getjPhone() {
		return jPhone;
	}

	public void setjPhone(String jPhone) {
		this.jPhone = jPhone == null ? null : jPhone.trim();
	}

	public String getjCode() {
		return jCode;
	}

	public void setjCode(String jCode) {
		this.jCode = jCode == null ? null : jCode.trim();
	}

	public String getjData() {
		return jData;
	}

	public void setjData(String jData) {
		this.jData = jData == null ? null : jData.trim();
	}
}