package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.CadetCollegeListModel;
import com.baf.musafir.bafphonebook.model.OthersListModel;

import java.util.Vector;


public class AllCadetCollegeListVector {
    public static Vector<CadetCollegeListModel> cadetCollegeListModels = new Vector<CadetCollegeListModel>();

    public static Vector<CadetCollegeListModel> getAllCadetCollegelist() {
        return cadetCollegeListModels;
    }

    public static void setAllCadetCollegelist(Vector<CadetCollegeListModel> cadetCollegeListModels) {
        AllCadetCollegeListVector.cadetCollegeListModels = cadetCollegeListModels;
    }

    public static CadetCollegeListModel getAllCadetCollegelist(int pos) {
        return cadetCollegeListModels.elementAt(pos);
    }

    public static void setAllCadetCollegelist(CadetCollegeListModel cadetCollegeListModels) {
        AllCadetCollegeListVector.cadetCollegeListModels.addElement(cadetCollegeListModels);
    }

    public static void removeCadetCollegelist() {
        AllCadetCollegeListVector.cadetCollegeListModels.removeAllElements();
    }
}
