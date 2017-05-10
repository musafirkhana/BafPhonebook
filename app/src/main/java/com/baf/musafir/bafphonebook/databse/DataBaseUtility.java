package com.baf.musafir.bafphonebook.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.holder.AllNwdListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.NwdListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;


public class DataBaseUtility {
private static String TAG="DataBaseUtility";
	/**
	 * Getting All Contact from DB
	 */
	public void getAirHqLodgerData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from mobile_no where base_id='1' ;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllContactListVector contactListVector = new AllContactListVector();
		contactListVector.removeContactlist();
		if (cursor.moveToFirst()) {
			do {
				ContactListModel contactListModel = new ContactListModel();
				contactListModel.setDesignation(cursor.getString(0));
				contactListModel.setMobileno(cursor.getString(1));
				contactListModel.setBase_id(cursor.getString(2));
				contactListModel.setBase_name(cursor.getString(3));
				contactListVector.setAllContactlist(contactListModel);
				contactListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	/**
	 * Getting All Contact from DB
	 * Contact Number of ZHR Base
	 * Because unit_1=2(ZHR)
	 */
	public void getZhrData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from mobile_no where base_id='2' ;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllContactListVector contactListVector = new AllContactListVector();
		contactListVector.removeContactlist();
		if (cursor.moveToFirst()) {
			do {
				ContactListModel contactListModel = new ContactListModel();
				contactListModel.setDesignation(cursor.getString(0));
				contactListModel.setMobileno(cursor.getString(1));
				contactListModel.setBase_id(cursor.getString(2));
				contactListModel.setBase_name(cursor.getString(3));
				contactListVector.setAllContactlist(contactListModel);
				contactListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	/**
	 * Getting All Contact from DB
	 */
	public void getZhrHQData(Context context ,String baseID,String wingID,String sqnID){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from pabs_data where base_id='" +
						baseID +
						"' and wing_id='" +
						wingID +
						"' and sqn_id='" +
						sqnID +
						"';",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllPabxListVector pabxListVector = new AllPabxListVector();
		pabxListVector.removePabxlist();
		if (cursor.moveToFirst()) {
			do {
				PabxListModel pabxListModel = new PabxListModel();
				pabxListModel.setDesignation(cursor.getString(6));
				pabxListModel.setOffice_auto(cursor.getString(8));
				pabxListModel.setOffice_ext(cursor.getString(7));
				pabxListModel.setResident_auto(cursor.getString(10));
				pabxListModel.setResident_ext(cursor.getString(9));
				pabxListModel.setMobile_no(cursor.getString(14));
				pabxListModel.setBase_name(cursor.getString(0));
				pabxListModel.setSqn_name(cursor.getString(2));
				pabxListModel.setWing_name(cursor.getString(4));
				pabxListVector.setAllPabxlist(pabxListModel);
				pabxListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}

	/***
	 * Get All Nwd Data
	 * @param context
     */
	public void getNwdData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from nwd_code;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllNwdListVector allNwdListVector = new AllNwdListVector();
		allNwdListVector.removeNwdlist();
		if (cursor.moveToFirst()) {
			do {
				NwdListModel nwdListModel = new NwdListModel();
				nwdListModel.setArea(cursor.getString(0));
				nwdListModel.setCode(cursor.getString(1));

				allNwdListVector.setAllNwdlist(nwdListModel);
				nwdListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	/**
	 * Getting All Contact from DB
	 */
	public void getAllData(Context context){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from pabs_data;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllPabxListVector pabxListVector = new AllPabxListVector();
		pabxListVector.removePabxlist();
		if (cursor.moveToFirst()) {
			do {
				PabxListModel pabxListModel = new PabxListModel();
				pabxListModel.setDesignation(cursor.getString(6));
				pabxListModel.setOffice_auto(cursor.getString(8));
				pabxListModel.setOffice_ext(cursor.getString(7));
				pabxListModel.setResident_auto(cursor.getString(10));
				pabxListModel.setResident_ext(cursor.getString(9));
				pabxListModel.setMobile_no(cursor.getString(14));
				pabxListModel.setBase_name(cursor.getString(0));
				pabxListModel.setSqn_name(cursor.getString(2));
				pabxListModel.setWing_name(cursor.getString(4));
				pabxListVector.setAllPabxlist(pabxListModel);
				pabxListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
}
