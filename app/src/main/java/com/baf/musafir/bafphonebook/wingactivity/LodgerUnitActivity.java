package com.baf.musafir.bafphonebook.wingactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.PabxListActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class LodgerUnitActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lodger_unit);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void LODGER1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","1");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_1));
        startActivity(intent);

    }

    public void LODGER2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_2));
        startActivity(intent);

    }
    public void LODGER3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_3));
        startActivity(intent);

    }
    public void LODGER4(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_4));
        startActivity(intent);

    }
    public void LODGER5(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","5");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_5));
        startActivity(intent);

    }
    public void LODGER6(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","6");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_6));
        startActivity(intent);

    }
    public void LODGER7(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","7");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_7));
        startActivity(intent);

    }
    public void LODGER8(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","7","8");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.lodger_8));
        startActivity(intent);

    }

}
