package com.baf.musafir.bafphonebook.model;

public class EmailListModel {


	private String designation = "";
	private String email_add = "";
	private String unit_base = "";
	private String unit_id = "";

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail_add() {
		return email_add;
	}

	public void setEmail_add(String email_add) {
		this.email_add = email_add;
	}

	public String getUnit_base() {
		return unit_base;
	}

	public void setUnit_base(String unit_base) {
		this.unit_base = unit_base;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	@Override
	public String toString() {
		return "EmailListModel{" +
				"designation='" + designation + '\'' +
				", email_add='" + email_add + '\'' +
				", unit_base='" + unit_base + '\'' +
				", unit_id='" + unit_id + '\'' +
				'}';
	}
}
