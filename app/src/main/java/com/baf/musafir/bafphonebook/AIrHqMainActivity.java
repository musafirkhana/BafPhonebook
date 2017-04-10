package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class AIrHqMainActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_airhq_main);
        mContext=this;
    }

    public void LODGER(View v) {
        Intent intent = new Intent(this, ContactListActivity.class);
        startActivity(intent);

    }

    public void CANTD(View v) {
        /*Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);*/

    }


}
