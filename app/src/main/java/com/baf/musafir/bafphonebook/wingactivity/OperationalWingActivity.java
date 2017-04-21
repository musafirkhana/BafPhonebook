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

public class OperationalWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ops_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }


    public void OPS1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","3","1");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.ops_0));
        startActivity(intent);

    }
    public void OPS2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","3","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.ops_1));
        startActivity(intent);

    }
    public void OPS3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","3","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.ops_2));
        startActivity(intent);

    }
    public void OPS4(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","3","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.ops_3));
        startActivity(intent);

    }




}
