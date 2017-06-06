package com.baf.musafir.bafphonebook.model;

public class CadetCollegeListModel {

    private String collage_name = "";
    private String designation = "";
    private String mobile_no = "";

    public String getCollage_name() {
        return collage_name;
    }

    public void setCollage_name(String collage_name) {
        this.collage_name = collage_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "CadetCollegeListModel{" +
                "collage_name='" + collage_name + '\'' +
                ", designation='" + designation + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                '}';
    }
}
