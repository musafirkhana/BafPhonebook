package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class HomeActivity extends Activity  {
    private Context mContext;
    private DataBaseUtility dataBaseUtility;

    private LinearLayout main_menu_li;
    private ImageView menu_imageview;
    private AlertDialog mGPSDialog;
    private static final int GPS_ENABLE_REQUEST = 0x1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext = this;
        dataBaseUtility = new DataBaseUtility();
        initUI();
    }

    private void initUI() {
        main_menu_li = (LinearLayout) findViewById(R.id.main_menu_li);
        menu_imageview=(ImageView)findViewById(R.id.menu_imageview);
    }public void ABBR(View v) {
        Intent intent = new Intent(this, GenerelAbbribiationActivity.class);
        intent.putExtra("header","ABBRIATION");
        startActivity(intent);
    }

    public void AIRHQ(View v) {
        dataBaseUtility.getAirHqLodgerData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header", "AIR HQ & ITS LODGER UNITS");
        startActivity(intent);
    }
    public void SEARCH(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "0");
        startActivity(intent);

    }

    public void ZHR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "2");
        startActivity(intent);
    }
    public void MTR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "3");
        startActivity(intent);
    }
    public void PKP(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "7");
        startActivity(intent);
    }
    public void BBD(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "6");
        startActivity(intent);
    }
    public void BSR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "4");
        startActivity(intent);
    }
    public void COXS(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", "5");
        startActivity(intent);
    }


    public void MENU(View v) {
        if (main_menu_li.getVisibility() == View.VISIBLE) {
            main_menu_li.startAnimation(outToleftAnimation());
            main_menu_li.setVisibility(View.GONE);
        } else {
            main_menu_li.startAnimation(inFromLeftAnimation());
            main_menu_li.setVisibility(View.VISIBLE);
            main_menu_li.bringToFront();

        }
    }
    public void BLANKLI(View v) {
        if (main_menu_li.getVisibility() == View.VISIBLE) {
            main_menu_li.startAnimation(outToleftAnimation());
            main_menu_li.setVisibility(View.GONE);
        } else {
            main_menu_li.startAnimation(inFromLeftAnimation());
            main_menu_li.setVisibility(View.VISIBLE);
            main_menu_li.bringToFront();

        }
    }

    public void NUMBERPLAN(View v) {
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, NumberPlanningActivity.class);
        startActivity(intent);
    }

    public void NWD(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, NwdListActivity.class);
        startActivity(intent);
    }

    public void RANK(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }

    public void HIS(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void LOC(View v) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            dataBaseUtility.getLocationData(mContext);
            main_menu_li.startAnimation(outToleftAnimation());
            main_menu_li.setVisibility(View.GONE);
            Intent intent = new Intent(this, LocationMapActivity.class);
            startActivity(intent);
        }else
        {
            showGPSDiabledDialog();
        }


    }
   /* public void GENABB(View v) {
        //dataBaseUtility.getAbbrData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, GenerelAbbribiationActivity.class);
        intent.putExtra("header","ABBRIATION");
        startActivity(intent);
    }*/
    public void ANTHEM(View v) {

        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, NationalAnthemActivity.class);
        startActivity(intent);
    }
    public void FIRESERVICE(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, OthersMainActivity.class);
        intent.putExtra("orgCode","5");
        intent.putExtra("orgName","FIRE SERVICE");
        startActivity(intent);
    }
    public void HOTEL(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, OthersMainActivity.class);
        intent.putExtra("orgCode","8");
        intent.putExtra("orgName","HOTEL");
        startActivity(intent);
    }
    public void BANK(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, OthersMainActivity.class);
        intent.putExtra("orgCode","7");
        intent.putExtra("orgName","BANK");
        startActivity(intent);
    }
    public void CADETCOLLEGE(View v) {
        dataBaseUtility.getCCData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, CadetCollegeListActivity.class);
        intent.putExtra("header","CADET COLLEGE");
        startActivity(intent);
    }


    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToleftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_imageview:
                Toast.makeText(mContext,"dsdsds",Toast.LENGTH_LONG);
                if (main_menu_li.getVisibility() == View.VISIBLE) {
                    main_menu_li.startAnimation(outToRightAnimation());
                    main_menu_li.setVisibility(View.GONE);
                } else {
                    main_menu_li.startAnimation(inFromRightAnimation());
                    main_menu_li.setVisibility(View.VISIBLE);
                    main_menu_li.bringToFront();

                }
                break;
        }
    }*/

    public void showGPSDiabledDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GPS Disabled");
        builder.setMessage("Gps is disabled, in order to use the application properly you need to enable GPS of your device");
        builder.setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), GPS_ENABLE_REQUEST);
            }
        }).setNegativeButton("No, Just Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        mGPSDialog = builder.create();
        mGPSDialog.show();
    }
}
