package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.wingactivity.NumberPlanningActivity;

public class HomeActivity extends Activity  {
    private Context mContext;
    private DataBaseUtility dataBaseUtility;

    private LinearLayout main_menu_li;
    private ImageView menu_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext = this;
        dataBaseUtility = new DataBaseUtility();
        initUI();
    }

    private void initUI() {
        main_menu_li = (LinearLayout) findViewById(R.id.main_menu_li);
        menu_imageview=(ImageView)findViewById(R.id.menu_imageview);
    }

    public void AIRHQ(View v) {
        dataBaseUtility.getAirHqLodgerData(mContext);
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header", "AIR HQ & ITS LODGER UNITS");
        startActivity(intent);
    }
    public void SEARCH(View v) {
        dataBaseUtility.getAllData(mContext);
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("header","SEARCH");
        startActivity(intent);

    }

    public void ZHR(View v) {
        Intent intent = new Intent(this, ZhrActivity.class);
        intent.putExtra("header", "AIR HQ & ITS LODGER UNITS");
        startActivity(intent);
    }
    public void MENU(View v) {
        if (main_menu_li.getVisibility() == View.VISIBLE) {
            main_menu_li.startAnimation(outToleftAnimation());
            main_menu_li.setVisibility(View.GONE);
        } else {
            main_menu_li.startAnimation(inFromLeftAnimation());
            main_menu_li.setVisibility(View.VISIBLE);
            main_menu_li.bringToFront();

        }
    }
    public void NUMBERPLAN(View v) {
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, NumberPlanningActivity.class);
        startActivity(intent);
    }

    public void NWD(View v) {
        dataBaseUtility.getNwdData(mContext);
        main_menu_li.startAnimation(outToleftAnimation());
        main_menu_li.setVisibility(View.GONE);
        Intent intent = new Intent(this, NwdListActivity.class);
        startActivity(intent);
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToleftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_imageview:
                Toast.makeText(mContext,"dsdsds",Toast.LENGTH_LONG);
                if (main_menu_li.getVisibility() == View.VISIBLE) {
                    main_menu_li.startAnimation(outToRightAnimation());
                    main_menu_li.setVisibility(View.GONE);
                } else {
                    main_menu_li.startAnimation(inFromRightAnimation());
                    main_menu_li.setVisibility(View.VISIBLE);
                    main_menu_li.bringToFront();

                }
                break;
        }
    }*/
}
