package com.baf.musafir.bafphonebook.model;

public class OthersListModel {

	private String org_name = "";
	private String org_id = "";
	private String designation = "";
	private String office_ext = "";
	private String res_ext = "";

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOffice_ext() {
		return office_ext;
	}

	public void setOffice_ext(String office_ext) {
		this.office_ext = office_ext;
	}

	public String getRes_ext() {
		return res_ext;
	}

	public void setRes_ext(String res_ext) {
		this.res_ext = res_ext;
	}

	@Override
	public String toString() {
		return "OthersListModel{" +
				"org_name='" + org_name + '\'' +
				", org_id='" + org_id + '\'' +
				", designation='" + designation + '\'' +
				", office_ext='" + office_ext + '\'' +
				", res_ext='" + res_ext + '\'' +
				'}';
	}
}
