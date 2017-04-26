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

public class TrainingWingActivity extends Activity {
private Context mContext;
    private DataBaseUtility dataBaseUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_training_wing);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
    }

    public void TRG1(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","6","1");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.training_0));
        startActivity(intent);

    }
    public void TRG2(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","6","2");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.training_1));
        startActivity(intent);

    }
    public void TRG3(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","6","3");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.training_2));
        startActivity(intent);

    }
    public void TRG4(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","6","4");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.training_3));
        startActivity(intent);

    }
    public void TRG5(View v) {
        dataBaseUtility.getZhrHQData(mContext,"2","6","5");
        Intent intent = new Intent(this, PabxListActivity.class);
        intent.putExtra("header",getString(R.string.training_4));
        startActivity(intent);

    }

}
