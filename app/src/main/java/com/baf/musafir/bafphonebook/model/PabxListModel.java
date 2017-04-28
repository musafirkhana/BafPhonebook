package com.baf.musafir.bafphonebook.model;

public class PabxListModel {

	private String base_name = "";
	private String base_id = "";
	private String wing_name = "";
	private String wing_id = "";
	private String sqn_name = "";
	private String sqn_id = "";
	private String designation = "";
	private String office_ext = "";
	private String office_auto = "";
	private String resident_ext = "";
	private String resident_auto = "";
	private String mobile_no = "";

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}

	public String getBase_id() {
		return base_id;
	}

	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}

	public String getWing_name() {
		return wing_name;
	}

	public void setWing_name(String wing_name) {
		this.wing_name = wing_name;
	}

	public String getWing_id() {
		return wing_id;
	}

	public void setWing_id(String wing_id) {
		this.wing_id = wing_id;
	}

	public String getSqn_name() {
		return sqn_name;
	}

	public void setSqn_name(String sqn_name) {
		this.sqn_name = sqn_name;
	}

	public String getSqn_id() {
		return sqn_id;
	}

	public void setSqn_id(String sqn_id) {
		this.sqn_id = sqn_id;
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

	public String getOffice_auto() {
		return office_auto;
	}

	public void setOffice_auto(String office_auto) {
		this.office_auto = office_auto;
	}

	public String getResident_ext() {
		return resident_ext;
	}

	public void setResident_ext(String resident_ext) {
		this.resident_ext = resident_ext;
	}

	public String getResident_auto() {
		return resident_auto;
	}

	public void setResident_auto(String resident_auto) {
		this.resident_auto = resident_auto;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "PabxListModel{" +
				"base_name='" + base_name + '\'' +
				", base_id='" + base_id + '\'' +
				", wing_name='" + wing_name + '\'' +
				", wing_id='" + wing_id + '\'' +
				", sqn_name='" + sqn_name + '\'' +
				", sqn_id='" + sqn_id + '\'' +
				", designation='" + designation + '\'' +
				", office_ext='" + office_ext + '\'' +
				", office_auto='" + office_auto + '\'' +
				", resident_ext='" + resident_ext + '\'' +
				", resident_auto='" + resident_auto + '\'' +
				", mobile_no='" + mobile_no + '\'' +
				'}';
	}
}
