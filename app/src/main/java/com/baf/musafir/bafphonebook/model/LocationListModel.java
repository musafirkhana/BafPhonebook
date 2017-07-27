package com.baf.musafir.bafphonebook.model;

public class LocationListModel {

	private String latitude = "";
	private String longitude = "";
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
				", place_name='" + place_name + '\'' +
				'}';
	}
}
