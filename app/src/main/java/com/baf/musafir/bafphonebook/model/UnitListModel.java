package com.baf.musafir.bafphonebook.model;

public class UnitListModel {

	private String Unit = "";
	private String Types = "";
	private String base_name = "";
	private String others = "";

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public String getTypes() {
		return Types;
	}

	public void setTypes(String types) {
		Types = types;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "UnitListModel{" +
				"Unit='" + Unit + '\'' +
				", Types='" + Types + '\'' +
				", base_name='" + base_name + '\'' +
				", others='" + others + '\'' +
				'}';
	}
}
