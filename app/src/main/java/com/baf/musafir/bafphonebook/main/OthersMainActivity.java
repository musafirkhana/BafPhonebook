package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class OthersMainActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private String orgCode="";
    private String orgName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_others_main);
        mContext=this;
        orgCode=getIntent().getStringExtra("orgCode");
        orgName=getIntent().getStringExtra("orgName");
        dataBaseUtility = new DataBaseUtility();
    }
    public void HOME(View v) {
        this.finish();
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);

    }
    public void CHITTAGONG(View v) {

        dataBaseUtility.getOthersData(mContext,orgCode,"1");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header",orgName+",CHITTAGONG AREA");
        startActivity(intent);

    }
    public void DHAKA(View v) {
        dataBaseUtility.getOthersData(mContext,orgCode,"1");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","DHAKA AREA");
        startActivity(intent);

    }

    public void JESSORE(View v) {
        dataBaseUtility.getOthersData(mContext,orgCode,"1");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","JESSORE AREA");
        startActivity(intent);

    }





}
