package com.baf.musafir.bafphonebook.model;

public class OthersListModel {

	private String org_code = "";
	private String org_name = "";
	private String area_code = "";
	private String area_name = "";
	private String designation = "";
	private String number = "";

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "OthersListModel{" +
				"org_code='" + org_code + '\'' +
				", org_name='" + org_name + '\'' +
				", area_code='" + area_code + '\'' +
				", area_name='" + area_name + '\'' +
				", designation='" + designation + '\'' +
				", number='" + number + '\'' +
				'}';
	}
}
