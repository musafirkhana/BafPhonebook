package com.baf.musafir.bafphonebook.zhr;

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

public class FlyingWingActivity extends Activity {
    private Context mContext;

    private ToastUtil toastUtil;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private String wingID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhr_flying_wing);
        mContext = this;
        toastUtil = new ToastUtil(this);
        dataBaseUtility = new DataBaseUtility();
        baseID = getIntent().getStringExtra("base_id");
        wingID = getIntent().getStringExtra("wing_id");
    }
    public void BACK(View v) {
        this.finish();
    }

    public void FLY1(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"2");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , "+getResources().getString(R.string.fly_1));
        startActivity(intent);
    }
    public void FLY2(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"3");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , "+getResources().getString(R.string.fly_2));
        startActivity(intent);
    }
    public void FLY3(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"4");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , "+getResources().getString(R.string.fly_3));
        startActivity(intent);
    }
    public void FLY4(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"5");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , "+getResources().getString(R.string.fly_4));
        startActivity(intent);
    }
    public void FLY5(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"6");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , "+getResources().getString(R.string.fly_5));
        startActivity(intent);
    }




}
