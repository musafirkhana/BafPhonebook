package com.baf.musafir.bafphonebook.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.model.ContactListModel;


public class DataBaseUtility {
private static String TAG="DataBaseUtility";
	/**
	 * Getting All Contact from DB
	 */
	public void getContactData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from mobile_no ;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllContactListVector contactListVector = new AllContactListVector();
		contactListVector.removeContactlist();
		if (cursor.moveToFirst()) {
			do {
				ContactListModel contactListModel = new ContactListModel();
				contactListModel.setDesignation(cursor.getString(0));
				contactListModel.setMobileno(cursor.getString(1));
				contactListModel.setUnit1(cursor.getString(2));
				contactListVector.setAllContactlist(contactListModel);
				contactListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	


}
