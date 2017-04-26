package com.baf.musafir.bafphonebook.wingactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.ContactListActivity;
import com.baf.musafir.bafphonebook.PabxListActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class AdminWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_admin_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void ADMIN1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","5","1");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.admin_0));
        startActivity(intent);

    }
    public void ADMIN2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","5","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.admin_1));
        startActivity(intent);

    }
    public void ADMIN3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","5","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.admin_2));
        startActivity(intent);

    }
    public void ADMIN4(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","5","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.admin_3));
        startActivity(intent);

    }
    public void ADMIN5(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","5","5");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.admin_4));
        startActivity(intent);

    }


}
