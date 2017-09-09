package com.baf.musafir.bafphonebook.holder;

import com.baf.musafir.bafphonebook.model.RankListModel;
import com.baf.musafir.bafphonebook.model.UnitListModel;

import java.util.Vector;


public class AllUnitListVector {
    public static Vector<UnitListModel> unitListModels = new Vector<UnitListModel>();

    public static Vector<UnitListModel> getAllUnitlist() {
        return unitListModels;
    }

    public static void setAllUnitlist(Vector<UnitListModel> unitListModels) {
        AllUnitListVector.unitListModels = unitListModels;
    }

    public static UnitListModel getAllUnitlist(int pos) {
        return unitListModels.elementAt(pos);
    }

    public static void setAllUnitlist(UnitListModel unitListModels) {
        AllUnitListVector.unitListModels.addElement(unitListModels);
    }

    public static void removeUnitlist() {
        AllUnitListVector.unitListModels.removeAllElements();
    }
}
