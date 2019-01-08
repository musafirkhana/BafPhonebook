package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.NumberPlanListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.util.Vector;


public class AllNumberPlanListVector {
	public static Vector<NumberPlanListModel> numberPlanListModels = new Vector<NumberPlanListModel>();

	public static Vector<NumberPlanListModel> getAllNumberPlanlist() {
		return numberPlanListModels;
	}

	public static void setAllNumberPlanlist(Vector<NumberPlanListModel> numberPlanListModels) {
		AllNumberPlanListVector.numberPlanListModels = numberPlanListModels;
	}

	public static NumberPlanListModel getAllNumberPlanlist(int pos) {
		return numberPlanListModels.elementAt(pos);
	}

	public static void setAllNumberPlanlist(NumberPlanListModel numberPlanListModels) {
		AllNumberPlanListVector.numberPlanListModels.addElement(numberPlanListModels);
	}

	public static void removeNumberPlanlist() {
		AllNumberPlanListVector.numberPlanListModels.removeAllElements();
	}
}
