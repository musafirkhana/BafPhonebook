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

public class FlyingWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_flying_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void HQ(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","2","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.fw_hq));
        startActivity(intent);

    }

    public void SQN0(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","2","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.one_sqn));
        startActivity(intent);

    }
    public void SQN1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","2","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.three_sqn));
        startActivity(intent);

    }
    public void SQN2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","2","5");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.twentyone_sqn));
        startActivity(intent);

    }
    public void SQN3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","2","6");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.twentyfive_sqn));
        startActivity(intent);

    }


}
