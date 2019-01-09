package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.DetailListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.util.Vector;


public class AllDetailListVector {
	public static Vector<DetailListModel> detailListModels = new Vector<DetailListModel>();

	public static Vector<DetailListModel> getAllDetaillist() {
		return detailListModels;
	}

	public static void setAllDetaillist(Vector<DetailListModel> detailListModels) {
		AllDetailListVector.detailListModels = detailListModels;
	}

	public static DetailListModel getAllDetaillist(int pos) {
		return detailListModels.elementAt(pos);
	}

	public static void setAllDetaillist(DetailListModel detailListModels) {
		AllDetailListVector.detailListModels.addElement(detailListModels);
	}

	public static void removeDetaillist() {
		AllDetailListVector.detailListModels.removeAllElements();
	}
}
