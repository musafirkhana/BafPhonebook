package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.NwdListModel;
import com.baf.musafir.bafphonebook.model.OthersListModel;

import java.util.Vector;


public class AllOthersListVector {
    public static Vector<OthersListModel> othersListModels = new Vector<OthersListModel>();

    public static Vector<OthersListModel> getAllOtherslist() {
        return othersListModels;
    }

    public static void setAllOtherslist(Vector<OthersListModel> othersListModels) {
        AllOthersListVector.othersListModels = othersListModels;
    }

    public static OthersListModel getAllOtherslist(int pos) {
        return othersListModels.elementAt(pos);
    }

    public static void setAllOtherslist(OthersListModel othersListModels) {
        AllOthersListVector.othersListModels.addElement(othersListModels);
    }

    public static void removeOtherslist() {
        AllOthersListVector.othersListModels.removeAllElements();
    }
}
