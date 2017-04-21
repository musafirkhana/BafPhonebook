package com.baf.musafir.bafphonebook.wingactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.ContactListActivity;
import com.baf.musafir.bafphonebook.PabxListActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class WingMainActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wing_main);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }
    public void BASEHQ(View v) {

        dataBaseUtility.getZhrHQData(mContext);
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header","BASE HEADQUARTER");
        startActivity(intent);

    }
    public void FLYING(View v) {
        Intent intent = new Intent(this, FlyingWingActivity.class);
        intent.putExtra("header","FLYING WING");
        startActivity(intent);

    }

    public void OPS(View v) {
        Intent intent = new Intent(this, OperationalWingActivity.class);
        intent.putExtra("header","OPERATIONAL WING");
        startActivity(intent);

    }
    public void ADMIN(View v) {
        Intent intent = new Intent(this, AdminWingActivity.class);
        intent.putExtra("header","ADMIN WING");
        startActivity(intent);

    }
    public void MAINTAIN(View v) {
        Intent intent = new Intent(this, MaintananceWingActivity.class);
        intent.putExtra("header","MAINTANCE WING");
        startActivity(intent);

    }
    public void TRAINING(View v) {
        Intent intent = new Intent(this, TrainingWingActivity.class);
        intent.putExtra("header","TRAINING WING");
        startActivity(intent);

    }


}
