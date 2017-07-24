package com.baf.musafir.bafphonebook.model;

public class RankListModel {

	private String rank_id = "";
	private String army = "";
	private String navvy = "";
	private String airforce = "";

	public String getRank_id() {
		return rank_id;
	}

	public void setRank_id(String rank_id) {
		this.rank_id = rank_id;
	}

	public String getArmy() {
		return army;
	}

	public void setArmy(String army) {
		this.army = army;
	}

	public String getNavvy() {
		return navvy;
	}

	public void setNavvy(String navvy) {
		this.navvy = navvy;
	}

	public String getAirforce() {
		return airforce;
	}

	public void setAirforce(String airforce) {
		this.airforce = airforce;
	}

	@Override
	public String toString() {
		return "RankListModel{" +
				"rank_id='" + rank_id + '\'' +
				", army='" + army + '\'' +
				", navvy='" + navvy + '\'' +
				", airforce='" + airforce + '\'' +
				'}';
	}
}
