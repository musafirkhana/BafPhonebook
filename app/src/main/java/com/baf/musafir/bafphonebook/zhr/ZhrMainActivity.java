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

public class ZhrMainActivity extends Activity {
    private Context mContext;

    private ToastUtil toastUtil;
    private String baseID = "";
    private DataBaseUtility dataBaseUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhr_main);
        mContext = this;
        toastUtil = new ToastUtil(this);
        dataBaseUtility=new DataBaseUtility();
        baseID = getIntent().getStringExtra("base_id");

    }
    public void ZHQ(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,"1","1");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "ZHR , BASE HQ");
        startActivity(intent);

    }

    public void WING1(View v) {
        Intent intent = new Intent(this, FlyingWingActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "2");
        startActivity(intent);

    }
    public void BACK(View v) {
       this.finish();
    }

    public void WING2(View v) {
        Intent intent = new Intent(this, OpsWingActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "3");
        startActivity(intent);

    }

    public void WING3(View v) {
        Intent intent = new Intent(this, MaintWingActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "4");
        startActivity(intent);

    }

    public void WING4(View v) {
        Intent intent = new Intent(this, AdminWingActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "5");
        startActivity(intent);

    }

    public void WING5(View v) {
        Intent intent = new Intent(this, TrgWingActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "6");
        startActivity(intent);

    }

    public void WING6(View v) {
        Intent intent = new Intent(this, LodgerUnitActivity.class);
        intent.putExtra("base_id", baseID);
        intent.putExtra("wing_id", "7");
        startActivity(intent);

    }


}
