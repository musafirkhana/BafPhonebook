package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.EmailListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.util.Vector;


public class AllEmailListVector {
	public static Vector<EmailListModel> emailListModels = new Vector<EmailListModel>();

	public static Vector<EmailListModel> getAllEmaillist() {
		return emailListModels;
	}

	public static void setAllEmaillist(Vector<EmailListModel> emailListModels) {
		AllEmailListVector.emailListModels = emailListModels;
	}

	public static EmailListModel getAllEmaillist(int pos) {
		return emailListModels.elementAt(pos);
	}

	public static void setAllEmaillist(EmailListModel emailListModels) {
		AllEmailListVector.emailListModels.addElement(emailListModels);
	}

	public static void removeEmaillist() {
		AllEmailListVector.emailListModels.removeAllElements();
	}
}
