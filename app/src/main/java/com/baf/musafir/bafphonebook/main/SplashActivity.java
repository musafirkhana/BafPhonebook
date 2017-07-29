package com.baf.musafir.bafphonebook.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseHelper;
import com.baf.musafir.bafphonebook.parser.AbbriviationListParser;
import com.baf.musafir.bafphonebook.util.AppConstant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    private String TAG = SplashActivity.class.getSimpleName();
    private TimerTask sostt;
    private final long period = 5000;
    private final int delay = 5000;
    private Timer sostimer;
    private Context context;

    private String text;
    private String respones_results;


    public static ProgressDialog progDialogConfirm;
    boolean flag = true;
    private File sdCard = Environment.getExternalStorageDirectory();
    private File edenRef_AppoinmentDir = new File(sdCard.getAbsolutePath() + AppConstant.DB_BASE_URL);
    private File mainDir = new File(sdCard.getAbsolutePath() + AppConstant.MAIN_DIR);
    private File edenRefDir = new File(sdCard.getAbsolutePath() + AppConstant.EDEN_REFERENCE_DIR);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        context = this;

       // initUI();
        // startTimer();
        initUI();
        flag = SharedPreferencesHelper.getFirstTime(context);
        if (flag) {
            Toast.makeText(context, "Export Database Starting....", Toast.LENGTH_LONG).show();
            exportDatabse();
        }
        createFolderStructure();
        new LoaddbAsyncTask().execute();

    }




    public void GO(View v) {
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }

    void stopTimer() {
        try {
            if (sostimer != null) {
                sostimer.cancel();
                sostimer = null;
            }
            if (sostt != null) {
                sostt.cancel();
                sostt = null;
            }
        } catch (final Exception e) {
        }
    }

    void startTimer() {
        try {
            sostimer = new Timer();
            sostt = new TimerTask() {

                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            stopTimer();
                            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                            startActivity(intent);
                            SplashActivity.this.finish();

                        }
                    });

                }
            };
            sostimer.schedule(sostt, delay, period);

        } catch (final Exception e) {
        }

    }

    /*******************************
     * Load Data From Asset Folder
     ***************/
    private void initUI() {
        try {
            InputStream is = getAssets().open("abbrfile.txt");

            // We guarantee that the available method returns the total
            // size of the asset... of course, this does mean that a single
            // asset can't be more than 2 gigs.
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            text = new String(buffer);
            Log.i("Hello ", text);

        } catch (IOException e) {
            // Should never happen!
            throw new RuntimeException(e);
        }

        themeList(text);

    }

    private void themeList(final String url_string) {

        final Thread d = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    respones_results = url_string;
                    if (AbbriviationListParser.connect(getApplicationContext(),
                            respones_results))
                        ;

                } catch (final Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        try {


                        } catch (Exception e) {
                        }
                    }

                });

            }
        });

        d.start();

    }


    /**********************************
     * Database Work Done Here(Export Database First Time)
     */
    /***************************
     * Create Folder Structure
     *****************/
    private void createFolderStructure() {
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        }

        if (!edenRefDir.exists()) {
            edenRefDir.mkdirs();
        }

        if (!edenRef_AppoinmentDir.exists()) {
            edenRef_AppoinmentDir.mkdirs();
        }


    }
    public class LoaddbAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /*progDialogConfirm = new ProgressDialog(SplashActivity.this);
            progDialogConfirm.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDialogConfirm.setMessage("Loading Database Please Wait ...");
            progDialogConfirm.show();*/
        }

        @Override
        protected String doInBackground(String... aurl) {
            loadDataBase();
            return null;
        }

        protected void onProgressUpdate(String... progress) {
            Log.d("ANDRO_ASYNC", progress[0]);
        }
        @SuppressLint("NewApi")
        protected void onPostExecute(String getResult) {
            //progDialogConfirm.dismiss();



          /*  final Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();*/

			/*if (SharedPreferencesHelper.getUserName(context).equalsIgnoreCase("")) {
				final Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			} else {
				final Intent intent = new Intent(SplashActivity.this, MainTabActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}*/

        }
    }

    public void loadDataBase() {
        DataBaseHelper myDbHelper = new DataBaseHelper(context);
        myDbHelper = new DataBaseHelper(this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);

        }

        try {

            try {
                myDbHelper.openDataBase();
            } catch (java.sql.SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (flag) {
                myDbHelper.copyDataBase();
            }

        } catch (SQLException sqle) {

            throw new Error(sqle);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void exportDatabse() {
        try {
            // File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (edenRef_AppoinmentDir.canWrite()) {
                String currentDBPath = "//data//" + getPackageName() + "//databases//" + AppConstant.DB_NAME + "";
                String backupDBPath = AppConstant.DB_NAME;
                File currentDB = new File(currentDBPath);
                File backupDB = new File(edenRef_AppoinmentDir, backupDBPath);
                if (currentDB.exists()) {
                    // FileChannel src = new
                    // FileInputStream(currentDB).getChannel();
                    // FileChannel dst = new
                    // FileOutputStream(backupDB).getChannel();
                    // dst.transferFrom(src, 0, src.size());
                    // src.close();
                    // dst.close();

                    FileInputStream fileInputStream = new FileInputStream(currentDB);
                    FileOutputStream fileOutputStream = new FileOutputStream(backupDB);
                    int bufferSize;
                    byte[] bufffer = new byte[8];
                    while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
                        fileOutputStream.write(bufffer, 0, bufferSize);
                    }
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            }
            SharedPreferencesHelper.setFirstTime(context, false);
        } catch (Exception e) {

        }
    }

    protected void onResume() {

        super.onResume();
        overridePendingTransition(0, 0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
