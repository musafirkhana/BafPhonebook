package com.baf.musafir.bafphonebook.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.baf.musafir.bafphonebook.holder.AllCadetCollegeListVector;
import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.holder.AllMobileListVector;
import com.baf.musafir.bafphonebook.holder.AllNwdListVector;
import com.baf.musafir.bafphonebook.holder.AllOthersListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.CadetCollegeListModel;
import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.MobileListModel;
import com.baf.musafir.bafphonebook.model.NwdListModel;
import com.baf.musafir.bafphonebook.model.OthersListModel;
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
	 * Contact Number of All Bases
	 */
	public void getAllMobileData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT * from mobile_no;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllMobileListVector contactListVector = new AllMobileListVector();
		contactListVector.removeMobilelist();
		if (cursor.moveToFirst()) {
			do {
				MobileListModel mobileListModel = new MobileListModel();
				mobileListModel.setDesignation(cursor.getString(0));
				mobileListModel.setMobileno(cursor.getString(1));
				mobileListModel.setBase_id(cursor.getString(2));
				mobileListModel.setBase_name(cursor.getString(3));
				contactListVector.setAllMobilelist(mobileListModel);
				mobileListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}


	/**
	 * Getting All Contact from DB
	 * Get Mobile number by Using base ID
	 * Individual Base Mobile NO
	 */
	public void getAllMobileDataByBaseID(Context context,String baseID ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT * from mobile_no  where base_id='" +
						baseID +
						"';",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllMobileListVector contactListVector = new AllMobileListVector();
		contactListVector.removeMobilelist();
		if (cursor.moveToFirst()) {
			do {
				MobileListModel mobileListModel = new MobileListModel();
				mobileListModel.setDesignation(cursor.getString(0));
				mobileListModel.setMobileno(cursor.getString(1));
				mobileListModel.setBase_id(cursor.getString(2));
				mobileListModel.setBase_name(cursor.getString(3));
				contactListVector.setAllMobilelist(mobileListModel);
				mobileListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
	/**
	 * Getting All Contact from DB
	 * Contact Number of ZHR Base HQ
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

	/***********************************
	 * Getting All Contact from DB
	 * Get Pabx Number by their base ID
	 ***********************************/
	public void getPabxDataByBaseID(Context context,String baseID){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from pabs_data where base_id='" +
						baseID +
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

	/**
	 * Getting All Contact from DB
	 */
	public void getOthersData(Context context ,String orgCode,String areaCode){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from others_number where org_code='" +
						orgCode +
						"' and area_code='" +
						areaCode +
						"';",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllOthersListVector allOthersListVector = new AllOthersListVector();
		allOthersListVector.removeOtherslist();
		if (cursor.moveToFirst()) {
			do {
				OthersListModel othersListModel = new OthersListModel();
				othersListModel.setOrg_code(cursor.getString(0));
				othersListModel.setOrg_name(cursor.getString(1));
				othersListModel.setArea_code(cursor.getString(2));
				othersListModel.setArea_name(cursor.getString(3));
				othersListModel.setDesignation(cursor.getString(4));
				othersListModel.setNumber(cursor.getString(5));

				allOthersListVector.setAllOtherslist(othersListModel);
				othersListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}


	/***
	 * Get All Cadet College Data
	 * @param context
	 */
	public void getCCData(Context context ){
		AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(context);
		SQLiteDatabase db = databaseOpenHelper.openDatabase();
		Log.w("Contact Data Data", "cnt: " + db.getPath());
		Log.w("Contact Data Data", "cnt: " + db.getVersion());

		Cursor cursor = db.rawQuery(
				"SELECT * from cadet_college;",
				null);
		Log.w("Contact Data Data", "cnt: " + cursor.getCount());
		AllCadetCollegeListVector allCadetCollegeListVector = new AllCadetCollegeListVector();
		allCadetCollegeListVector.removeCadetCollegelist();
		if (cursor.moveToFirst()) {
			do {
				CadetCollegeListModel cadetCollegeListModel = new CadetCollegeListModel();
				cadetCollegeListModel.setCollage_name(cursor.getString(0));
				cadetCollegeListModel.setDesignation(cursor.getString(1));
				cadetCollegeListModel.setMobile_no(cursor.getString(2));

				allCadetCollegeListVector.setAllCadetCollegelist(cadetCollegeListModel);
				cadetCollegeListModel = null;
				Log.w("Contact Data Data", "cnt: " + cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
	}
}
