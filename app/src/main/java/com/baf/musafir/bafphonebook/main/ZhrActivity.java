package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

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
    public void HOME(View v) {
        this.finish();
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);

    }
    public void LODGER(View v) {
        dataBaseUtility.getZhrData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header","MOBILE");
        startActivity(intent);

    }

    /*public void CANTD(View v) {
        Intent intent = new Intent(this, WingMainActivity.class);
        intent.putExtra("header","ZHR PABX");
        startActivity(intent);

    }*/


}
