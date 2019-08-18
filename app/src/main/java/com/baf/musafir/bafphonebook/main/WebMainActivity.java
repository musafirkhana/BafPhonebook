package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;

public class WebMainActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_website_main);
        mContext=this;

    }
    public void BAFWEB(View v) {

        Intent intent = new Intent(this, WebsiteActivity.class);
        intent.putExtra("url","https://www.baf.mil.bd/");
        startActivity(intent);
    }

    public void BAFMET(View v) {

        Intent intent = new Intent(this, WebsiteActivity.class);
        intent.putExtra("url","https://mtrwf.com/");
        startActivity(intent);
    }


    public void BACK(View v){
        this.finish();

    }

}
