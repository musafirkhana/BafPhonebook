package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class CommandControlActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_commandcontrol);
        mContext=this;
    }
    public void BACK(View v) {
        this.finish();

    }
    public void CMD1(View v) {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        intent.putExtra("cat","1");
        startActivity(intent);

    }
    public void CMD2(View v) {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        intent.putExtra("cat","2");
        startActivity(intent);

    }
    public void CMD3(View v) {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        intent.putExtra("cat","3");
        startActivity(intent);

    }
    public void CMD4(View v) {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        intent.putExtra("cat","4");
        startActivity(intent);

    }
    public void CMD5(View v) {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        intent.putExtra("cat","5");
        startActivity(intent);

    }
}
