package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class HomeActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext=this;
    }

    public void ZHRCLICK(View v) {
        Toast.makeText(mContext,"Clicket",Toast.LENGTH_LONG).show();

    }

    public void BBDCLICK(View v) {

    }

    public void BSRCLICK(View v) {

    }

    public void MTRCLICK(View v) {

    }

    public void PKPCLICK(View v) {

    }

    public void COXCLICK(View v) {

    }


}
