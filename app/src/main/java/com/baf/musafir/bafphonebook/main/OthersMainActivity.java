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
    private String header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_others_main);
        mContext=this;
        header=getIntent().getStringExtra("header");
        dataBaseUtility = new DataBaseUtility();
    }
    public void BACK(View v) {
        this.finish();

    }

    public void OTHERS1(View v) {

        dataBaseUtility.getOthersData(mContext,"1");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","President's Office");
        startActivity(intent);

    }
    public void OTHERS2(View v) {

        dataBaseUtility.getOthersData(mContext,"2");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Prime Minister's Office");
        startActivity(intent);

    }
    public void OTHERS3(View v) {

        dataBaseUtility.getOthersData(mContext,"3");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Special Security Force (SSF)");
        startActivity(intent);

    }
    public void OTHERS4(View v) {

        dataBaseUtility.getOthersData(mContext,"4");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Ministry of Defence (MOD)");
        startActivity(intent);

    }
    public void OTHERS5(View v) {

        dataBaseUtility.getOthersData(mContext,"5");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Armed Forces Division (AFD)");
        startActivity(intent);

    }
    public void OTHERS6(View v) {

        dataBaseUtility.getOthersData(mContext,"6");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Army Headquarters (AHQ)");
        startActivity(intent);

    }
    public void OTHERS7(View v) {

        dataBaseUtility.getOthersData(mContext,"7");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","Naval Headquarters (NHQ)");
        startActivity(intent);

    }
    public void OTHERS8(View v) {

        dataBaseUtility.getOthersData(mContext,"8");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","DGFI");
        startActivity(intent);

    }
    public void OTHERS9(View v) {

        dataBaseUtility.getOthersData(mContext,"9");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","DGDP");
        startActivity(intent);

    }
    public void OTHERS10(View v) {

        dataBaseUtility.getOthersData(mContext,"10");
        Intent intent = new Intent(this, OthersListActivity.class);
        intent.putExtra("header","ISSB,NDC,DSCSC");
        startActivity(intent);

    }







}
