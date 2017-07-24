package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.AbbrlListModel;
import com.baf.musafir.bafphonebook.model.RankListModel;

import java.util.Vector;


public class AllAbbrListVector {
    public static Vector<AbbrlListModel> abbrlListModels = new Vector<AbbrlListModel>();

    public static Vector<AbbrlListModel> getAllAbbrlist() {
        return abbrlListModels;
    }

    public static void setAllAbbrlist(Vector<AbbrlListModel> abbrlListModels) {
        AllAbbrListVector.abbrlListModels = abbrlListModels;
    }

    public static AbbrlListModel getAllAbbrlist(int pos) {
        return abbrlListModels.elementAt(pos);
    }

    public static void setAllAbbrlist(AbbrlListModel abbrlListModels) {
        AllAbbrListVector.abbrlListModels.addElement(abbrlListModels);
    }

    public static void removeAbbrlist() {
        AllAbbrListVector.abbrlListModels.removeAllElements();
    }
}
