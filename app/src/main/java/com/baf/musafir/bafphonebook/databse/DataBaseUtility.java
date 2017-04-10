package com.baf.musafir.bafphonebook.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DataBaseUtility {
private static String TAG="DataBaseUtility";
	/**
	 * Getting All Contact from DB
	 */
	public void getContactData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());

		Cursor cursor = db.rawQuery(
				"SELECT * from Telephone ;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		//AllContactListVector contactListVector = new AllContactListVector();
		//contactListVector.removeContactlist();
		if (cursor.moveToFirst()) {
			do {
				/*ContactListModel contactListModel = new ContactListModel();
				contactListModel.setName(cursor.getString(0));
				contactListModel.setJobRole(cursor.getString(1));
				contactListModel.setJobRoleDescription(cursor.getString(2));
				contactListModel.setPhoto(cursor.getString(3));
				contactListModel.setDisplayOnSite(cursor.getString(4));
				contactListModel.setDisplayOrder(cursor.getString(5));
				contactListModel.setPhone1(cursor.getString(6));
				contactListVector.setAllContactlist(contactListModel);
				contactListModel = null;*/
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	


}
