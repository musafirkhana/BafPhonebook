package com.baf.musafir.bafphonebook.mtr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.main.SearchListActivity;
import com.baf.musafir.bafphonebook.util.ToastUtil;

public class AdminWingActivity extends Activity {
    private Context mContext;

    private ToastUtil toastUtil;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private String wingID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhr_admin_wing);
        mContext = this;
        toastUtil = new ToastUtil(this);
        dataBaseUtility = new DataBaseUtility();
        baseID = getIntent().getStringExtra("base_id");
        wingID = getIntent().getStringExtra("wing_id");

    }
    public void BACK(View v) {
        this.finish();
    }

    public void ADMIN1(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"1");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.admin_0));
        startActivity(intent);

    }
    public void ADMIN2(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"2");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.admin_1));
        startActivity(intent);
    }
    public void ADMIN3(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"3");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.admin_2));
        startActivity(intent);
    }
    public void ADMIN4(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"4");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.admin_3));
        startActivity(intent);
    }
    public void ADMIN5(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"5");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.admin_4));
        startActivity(intent);

    }




}
