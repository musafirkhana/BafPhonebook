package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.AbbrlListModel;
import com.baf.musafir.bafphonebook.model.LocationListModel;

import java.util.Vector;


public class AllLocationListVector {
    public static Vector<LocationListModel> locationListModels = new Vector<LocationListModel>();

    public static Vector<LocationListModel> getAllLocationlist() {
        return locationListModels;
    }

    public static void setAllLocationlist(Vector<LocationListModel> locationListModels) {
        AllLocationListVector.locationListModels = locationListModels;
    }

    public static LocationListModel getAllLocationlist(int pos) {
        return locationListModels.elementAt(pos);
    }

    public static void setAllLocationlist(LocationListModel locationListModels) {
        AllLocationListVector.locationListModels.addElement(locationListModels);
    }

    public static void removeLocationlist() {
        AllLocationListVector.locationListModels.removeAllElements();
    }
}
