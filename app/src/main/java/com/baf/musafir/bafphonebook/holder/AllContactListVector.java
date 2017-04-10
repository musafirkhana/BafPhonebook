package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.ContactListModel;

import java.util.Vector;


public class AllContactListVector {
	public static Vector<ContactListModel> contactListModels = new Vector<ContactListModel>();

	public static Vector<ContactListModel> getAllContactlist() {
		return contactListModels;
	}

	public static void setAllContactlist(Vector<ContactListModel> contactListModels) {
		AllContactListVector.contactListModels = contactListModels;
	}

	public static ContactListModel getAllContactlist(int pos) {
		return contactListModels.elementAt(pos);
	}

	public static void setAllContactlist(ContactListModel contactListModels) {
		AllContactListVector.contactListModels.addElement(contactListModels);
	}

	public static void removeContactlist() {
		AllContactListVector.contactListModels.removeAllElements();
	}
}
