package com.baf.musafir.bafphonebook.model;

public class ContactListModel {

	private String Designation = "";
	private String Mobileno = "";
	private String base_id = "";
	private String base_name = "";

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getMobileno() {
		return Mobileno;
	}

	public void setMobileno(String mobileno) {
		Mobileno = mobileno;
	}

	public String getBase_id() {
		return base_id;
	}

	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}

	@Override
	public String toString() {
		return "ContactListModel{" +
				"Designation='" + Designation + '\'' +
				", Mobileno='" + Mobileno + '\'' +
				", base_id='" + base_id + '\'' +
				", base_name='" + base_name + '\'' +
				'}';
	}
}
