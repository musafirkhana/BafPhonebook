package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class RankActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rank);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }
    public void HOME(View v) {
        this.finish();


    }
    public void OFFICERS(View v) {

        dataBaseUtility.getRankData(mContext,"0");
        Intent intent = new Intent(this, RankDetailActivity.class);
        intent.putExtra("header","OFFICERS");
        startActivity(intent);

    }
    public void JCO(View v) {
        dataBaseUtility.getRankData(mContext,"1");
        Intent intent = new Intent(this, RankDetailActivity.class);
        intent.putExtra("header","JCO");
        startActivity(intent);

    }







}
