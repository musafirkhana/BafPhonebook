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

public class OpsWingActivity extends Activity {
    private Context mContext;

    private ToastUtil toastUtil;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private String wingID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mtr_ops_wing);
        mContext = this;
        toastUtil = new ToastUtil(this);
        dataBaseUtility = new DataBaseUtility();
        baseID = getIntent().getStringExtra("base_id");
        wingID = getIntent().getStringExtra("wing_id");

    }
    public void BACK(View v) {
        this.finish();
    }

    public void OPS1(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"1");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_0));
        startActivity(intent);

    }
    public void OPS2(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"2");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_1));
        startActivity(intent);

    }
    public void OPS3(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"3");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_2));
        startActivity(intent);

    }
    public void OPS4(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"4");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_3));
        startActivity(intent);

    }
    public void OPS5(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"5");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_4));
        startActivity(intent);

    }
    public void OPS6(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"6");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_5));
        startActivity(intent);

    }
    public void OPS7(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"7");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_6));
        startActivity(intent);

    }
    public void OPS8(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"8");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_7));
        startActivity(intent);

    }
    public void OPS9(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"9");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_8));
        startActivity(intent);

    }
    public void OPS10(View v) {
        dataBaseUtility.getPabxDataSqnID(mContext, baseID,wingID,"10");
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header", "MTR , "+getResources().getString(R.string.m_ops_9));
        startActivity(intent);

    }
}
