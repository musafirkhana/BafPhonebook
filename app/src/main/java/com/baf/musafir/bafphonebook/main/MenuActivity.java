package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.util.JustifiedTextView;

public class MenuActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private AlertDialog mGPSDialog;
    private static final int GPS_ENABLE_REQUEST = 0x1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();

    }
    public void NUMBERPLAN(View v) {

        Intent intent = new Intent(this, NumberPlanningActivity.class);
        startActivity(intent);
    }

    public void NWD(View v) {
        dataBaseUtility.getNwdData(mContext);

        Intent intent = new Intent(this, NwdListActivity.class);
        startActivity(intent);
    }

    public void RANK(View v) {
        dataBaseUtility.getNwdData(mContext);
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }
    public void UNIT(View v) {
        dataBaseUtility.getSqnUnitData(mContext,"2");
        Intent intent = new Intent(this, UnitDetailActivity.class);
        intent.putExtra("header","UNITS");
        startActivity(intent);
    }
    public void SQN(View v) {
        dataBaseUtility.getSqnUnitData(mContext,"1");
        Intent intent = new Intent(this, UnitDetailActivity.class);
        intent.putExtra("header","SQUADRON");
        startActivity(intent);
    }
    public void HIS(View v) {
        dataBaseUtility.getNwdData(mContext);
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void INFO(View v) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("header","EMAIL");
        startActivity(intent);
    }
    public void EMAIL(View v) {
        dataBaseUtility.getAllEmailAddData(mContext);
        Intent intent = new Intent(this, MailListActivity.class);
        startActivity(intent);
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

        Intent intent = new Intent(this, NationalAnthemActivity.class);
        startActivity(intent);
    }
    public void CMDCON(View v) {
        Intent intent = new Intent(this, CommandControlActivity.class);
        startActivity(intent);
    }
    public void HOTEL(View v) {
        dataBaseUtility.getNwdData(mContext);
        Intent intent = new Intent(this, OthersMainActivity.class);
        intent.putExtra("orgCode","8");
        intent.putExtra("orgName","HOTEL");
        startActivity(intent);
    }
    public void BANK(View v) {
        dataBaseUtility.getNwdData(mContext);
        Intent intent = new Intent(this, OthersMainActivity.class);
        intent.putExtra("orgCode","7");
        intent.putExtra("orgName","BANK");
        startActivity(intent);
    }
    public void CADETCOLLEGE(View v) {
        dataBaseUtility.getCCData(mContext);
        Intent intent = new Intent(this, CadetCollegeListActivity.class);
        intent.putExtra("header","CADET COLLEGE");
        startActivity(intent);
    }
public void BACK(View v){
    this.finish();

}
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
