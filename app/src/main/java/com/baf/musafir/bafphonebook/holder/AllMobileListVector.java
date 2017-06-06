package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.MobileListModel;

import java.util.Vector;


public class AllMobileListVector {
	public static Vector<MobileListModel> mobileListModels = new Vector<MobileListModel>();

	public static Vector<MobileListModel> getAllMobilelist() {
		return mobileListModels;
	}

	public static void setAllMobilelist(Vector<MobileListModel> contactListModels) {
		AllMobileListVector.mobileListModels = mobileListModels;
	}

	public static MobileListModel getAllMobilelist(int pos) {
		return mobileListModels.elementAt(pos);
	}

	public static void setAllMobilelist(MobileListModel mobileListModels) {
		AllMobileListVector.mobileListModels.addElement(mobileListModels);
	}

	public static void removeMobilelist() {
		AllMobileListVector.mobileListModels.removeAllElements();
	}
}
