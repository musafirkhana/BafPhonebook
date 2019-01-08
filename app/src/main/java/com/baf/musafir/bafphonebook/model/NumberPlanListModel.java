package com.baf.musafir.bafphonebook.model;

public class NumberPlanListModel {

	private String name = "";
	private String ext_code = "";
	private String mobile_code = "";
	private String service_id = "";
	private String service_name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt_code() {
		return ext_code;
	}

	public void setExt_code(String ext_code) {
		this.ext_code = ext_code;
	}

	public String getMobile_code() {
		return mobile_code;
	}

	public void setMobile_code(String mobile_code) {
		this.mobile_code = mobile_code;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	@Override
	public String toString() {
		return "NumberPlanListModel{" +
				"name='" + name + '\'' +
				", ext_code='" + ext_code + '\'' +
				", mobile_code='" + mobile_code + '\'' +
				", service_id='" + service_id + '\'' +
				", service_name='" + service_name + '\'' +
				'}';
	}
}
