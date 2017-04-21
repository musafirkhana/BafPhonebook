package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.util.Vector;


public class AllPabxListVector {
	public static Vector<PabxListModel> pabxListModels = new Vector<PabxListModel>();

	public static Vector<PabxListModel> getAllPabxlist() {
		return pabxListModels;
	}

	public static void setAllPabxlist(Vector<PabxListModel> pabxListModels) {
		AllPabxListVector.pabxListModels = pabxListModels;
	}

	public static PabxListModel getAllPabxlist(int pos) {
		return pabxListModels.elementAt(pos);
	}

	public static void setAllPabxlist(PabxListModel pabxListModels) {
		AllPabxListVector.pabxListModels.addElement(pabxListModels);
	}

	public static void removePabxlist() {
		AllPabxListVector.pabxListModels.removeAllElements();
	}
}
