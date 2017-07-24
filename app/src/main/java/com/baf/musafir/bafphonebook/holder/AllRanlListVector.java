package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.PabxListModel;
import com.baf.musafir.bafphonebook.model.RankListModel;

import java.util.Vector;


public class AllRanlListVector {
    public static Vector<RankListModel> rankListModels = new Vector<RankListModel>();

    public static Vector<RankListModel> getAllRanklist() {
        return rankListModels;
    }

    public static void setAllRanklist(Vector<RankListModel> rankListModels) {
        AllRanlListVector.rankListModels = rankListModels;
    }

    public static RankListModel getAllRanklist(int pos) {
        return rankListModels.elementAt(pos);
    }

    public static void setAllRanklist(RankListModel rankListModels) {
        AllRanlListVector.rankListModels.addElement(rankListModels);
    }

    public static void removeRanklist() {
        AllRanlListVector.rankListModels.removeAllElements();
    }
}
