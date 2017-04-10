package com.baf.musafir.bafphonebook.model;

public class ContactListModel {

	private String Designation = "";
	private String Mobileno = "";
	private String Unit1 = "";

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

	public String getUnit1() {
		return Unit1;
	}

	public void setUnit1(String unit1) {
		Unit1 = unit1;
	}

	@Override
	public String toString() {
		return "ContactListModel{" +
				"Designation='" + Designation + '\'' +
				", Mobileno='" + Mobileno + '\'' +
				", Unit1='" + Unit1 + '\'' +
				'}';
	}
}
