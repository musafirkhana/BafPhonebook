package com.baf.musafir.bafphonebook.model;

public class AbbrlListModel {

	private String Abbreviate = "";
	private String abbr = "";

	public String getAbbreviate() {
		return Abbreviate;
	}

	public void setAbbreviate(String abbreviate) {
		Abbreviate = abbreviate;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	@Override
	public String toString() {
		return "AbbrlListModel{" +
				"Abbreviate='" + Abbreviate + '\'' +
				", abbr='" + abbr + '\'' +
				'}';
	}
}
