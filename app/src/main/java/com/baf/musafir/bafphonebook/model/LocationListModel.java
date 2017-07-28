package com.baf.musafir.bafphonebook.model;

public class LocationListModel {

	private String latitude = "";
	private String longitude = "";
	private String service_id = "";
	private String place_name = "";

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	@Override
	public String toString() {
		return "LocationListModel{" +
				"latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", service_id='" + service_id + '\'' +
				", place_name='" + place_name + '\'' +
				'}';
	}
}
