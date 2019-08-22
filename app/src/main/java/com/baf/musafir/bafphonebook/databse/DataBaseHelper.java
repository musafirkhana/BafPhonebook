package com.baf.musafir.bafphonebook.databse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.baf.musafir.bafphonebook.util.AppConstant;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static String TAG = "DataBaseHelper"; // Tag just for the LogCat
													// window
	// destination path (location) of our database on device
	// private static String DB_PATH = "";
	private static String DB_NAME = AppConstant.DB_NAME;// Database name
	private SQLiteDatabase mDataBase;
	private final Context mContext;
	private File sdCard = Environment.getExternalStorageDirectory();
	File edenRef_AppoinmentDir = new File(sdCard.getAbsolutePath()
			+ AppConstant.DB_BASE_URL);
	private static String DB_SD_CARD_PATH = "";

	public DataBaseHelper(Context context) {
		super(context, DB_NAME, null, 1);// 1? its Database Version
		// DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		//DB_SD_CARD_PATH = sdCard.getAbsolutePath() + AppConstant.DB_BASE_URL;
		//DB_SD_CARD_PATH = "//data//" + context.getPackageName() + "//databases//" + AppConstant.DB_NAME + "";
		if (android.os.Build.VERSION.SDK_INT >= 17)
			DB_SD_CARD_PATH = context.getApplicationInfo().dataDir + "/databases/"+ AppConstant.DB_NAME + "";
		else
			DB_SD_CARD_PATH = "/data/data/" + context.getPackageName() + "/databases/"+ AppConstant.DB_NAME + "";
		Log.d("path", DB_SD_CARD_PATH);

		this.mContext = context;
	}

	public void createDataBase() throws IOException {
		// If database not exists copy it from the assets

		boolean mDataBaseExist = checkDataBase();
		if (mDataBaseExist) {
			Log.v("DB Exists", "db exists");
			/*this.getReadableDatabase();
			this.close();*/
			// try {
			// // Copy the database from assests
			// copyDataBase();
			// Log.w(TAG, "Database created");
			// } catch (IOException mIOException) {
			// throw new Error("ErrorCopyingDataBase");
			// }
		}
		boolean dbExist1 = checkDataBase();
		if(!dbExist1)
		{
			this.getReadableDatabase();
			try
			{
				this.close();
				copyDataBase();
			}
			catch (IOException e)
			{
				throw new Error("Error copying database");
			}
		}

	}

	// Check that the database exists here: /data/data/your package/databases/Da
	// Name
	private boolean checkDataBase() {
		File dbFile = new File(DB_SD_CARD_PATH + DB_NAME);
		// Log.v("dbFile", dbFile + "   "+ dbFile.exists());
		return dbFile.exists();
	}

	// Copy the database from assets
	public void copyDataBase() throws IOException {
		InputStream mInput = mContext.getAssets().open(DB_NAME);
		String outFileName = DB_SD_CARD_PATH + DB_NAME;
		OutputStream mOutput = new FileOutputStream(outFileName);
		byte[] mBuffer = new byte[1024];
		int mLength;
		while ((mLength = mInput.read(mBuffer)) > 0) {
			mOutput.write(mBuffer, 0, mLength);
		}
		mOutput.flush();
		mOutput.close();
		mInput.close();
	}

	// Open the database, so we can query it
	public boolean openDataBase() throws SQLException {
		String mPath = DB_SD_CARD_PATH + DB_NAME;
		mDataBase = SQLiteDatabase.openDatabase(mPath, null,
				SQLiteDatabase.CREATE_IF_NECESSARY);

		return mDataBase != null;
	}


	//delete database
	public void db_delete()
	{
		File file = new File(DB_SD_CARD_PATH + DB_NAME);
		if(file.exists())
		{
			file.delete();
			System.out.println("delete database file.");
		}
	}
	@Override
	public synchronized void close() {
		if (mDataBase != null)
			mDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	

}