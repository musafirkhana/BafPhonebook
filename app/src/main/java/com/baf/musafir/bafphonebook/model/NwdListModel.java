package com.baf.musafir.bafphonebook.model;

public class NwdListModel {

	private String area = "";
	private String code = "";

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "NwdListModel{" +
				"area='" + area + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
