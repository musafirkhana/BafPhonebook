package com.baf.musafir.bafphonebook.wingactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.ContactListActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class OperationalWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ops_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void LODGER(View v) {
        dataBaseUtility.getZhrData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header","MOBILE");
        startActivity(intent);

    }

    public void CANTD(View v) {
      /*  dataBaseUtility.getAirHqLodgerContdData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header","PABX");
        startActivity(intent);*/

    }


}
