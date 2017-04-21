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

public class MaintananceWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_maint_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void MAINT1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","1");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_0));
        startActivity(intent);

    }
    public void MAINT2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_1));
        startActivity(intent);

    }
    public void MAINT3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_2));
        startActivity(intent);

    }
    public void MAINT4(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_3));
        startActivity(intent);

    }
    public void MAINT5(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","5");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_4));
        startActivity(intent);

    }
    public void MAINT6(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","6");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_5));
        startActivity(intent);

    }
    public void MAINT7(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","7");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_6));
        startActivity(intent);

    }
    public void MAINT8(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","4","8");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.maint_7));
        startActivity(intent);

    }


}
