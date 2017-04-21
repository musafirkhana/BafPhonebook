package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class HomeActivity extends Activity {
    private Context mContext;
    private DataBaseUtility dataBaseUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext = this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void AIRHQ(View v) {
        dataBaseUtility.getAirHqLodgerData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header","AIR HQ & ITS LODGER UNITS");
        startActivity(intent);
    }
    public void ZHR(View v) {
        Intent intent = new Intent(this, ZhrActivity.class);
        intent.putExtra("header","AIR HQ & ITS LODGER UNITS");
        startActivity(intent);
    }

}
