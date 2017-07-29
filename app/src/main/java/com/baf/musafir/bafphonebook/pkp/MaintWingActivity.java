package com.baf.musafir.bafphonebook.pkp;

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

public class MaintWingActivity extends Activity {
    private Context mContext;

    private ToastUtil toastUtil;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private String wingID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pkp_maint_wing);
        mContext = this;
        toastUtil = new ToastUtil(this);
        dataBaseUtility = new DataBaseUtility();
        baseID = getIntent().getStringExtra("base_id");
        wingID = getIntent().getStringExtra("wing_id");

    }
    public void BACK(View v) {
        this.finish();
    }

    public void MAINT1(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"1");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.maint_0));
        startActivity(intent);

    }
    public void MAINT2(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"2");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_1));
        startActivity(intent);

    }
    public void MAINT3(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"3");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_2));
        startActivity(intent);

    }
    public void MAINT4(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"4");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_3));
        startActivity(intent);

    }
    public void MAINT5(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"5");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_4));
        startActivity(intent);

    }

    public void MAINT6(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"6");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_5));
        startActivity(intent);

    }
    public void MAINT7(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"7");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "PKP , "+getResources().getString(R.string.pkp_maint_6));
        startActivity(intent);

    }

}
