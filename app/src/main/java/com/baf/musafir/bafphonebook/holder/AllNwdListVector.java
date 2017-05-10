package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.NwdListModel;

import java.util.Vector;


public class AllNwdListVector {
	public static Vector<NwdListModel> nwdListModels = new Vector<NwdListModel>();

	public static Vector<NwdListModel> getAllNwdlist() {
		return nwdListModels;
	}

	public static void setAllNwdlist(Vector<NwdListModel> nwdListModels) {
		AllNwdListVector.nwdListModels = nwdListModels;
	}

	public static NwdListModel getAllNwdlist(int pos) {
		return nwdListModels.elementAt(pos);
	}

	public static void setAllNwdlist(NwdListModel nwdListModels) {
		AllNwdListVector.nwdListModels.addElement(nwdListModels);
	}

	public static void removeNwdlist() {
		AllNwdListVector.nwdListModels.removeAllElements();
	}
}
