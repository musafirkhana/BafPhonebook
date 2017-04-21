package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.wingactivity.WingMainActivity;

public class ZhrActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhr_main);
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
        Intent intent = new Intent(this, WingMainActivity.class);
        intent.putExtra("header","ZHR PABX");
        startActivity(intent);

    }


}
