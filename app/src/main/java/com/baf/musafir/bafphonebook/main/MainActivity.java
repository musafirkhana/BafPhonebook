package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.util.AppConstant;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends Activity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
    HashMap<String, Integer> HashMapForLocalRes;
    SliderLayout sliderLayout;
    private LinearLayout main_menu_li;
    private static final int GPS_ENABLE_REQUEST = 0x1001;
    private AlertDialog mGPSDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mContext=this;
        dataBaseUtility = new DataBaseUtility();
        initUI();
    }
    private void initUI() {
       // main_menu_li = (LinearLayout) findViewById(R.id.main_menu_li);
        sliderLayout = (SliderLayout) findViewById(R.id.slider);


        //Call this method to add images from local drawable folder .
        AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForLocalRes.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
    }
    public void ABBR(View v) {
        Intent intent = new Intent(this, GenerelAbbribiationActivity.class);
        intent.putExtra("header","ABBRIATION");
        startActivity(intent);
    }

    public void AIRHQ(View v) {
        //dataBaseUtility.getAirHqLodgerData(mContext);
        /*Intent intent = new Intent(this, ContactListActivity.class);
        intent.putExtra("header", "AIR HQ & ITS LODGER UNITS");
        startActivity(intent);*/

        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_AHQ);
        startActivity(intent);
    }
    public void SEARCH(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_SEARCH);
        startActivity(intent);

    }

    public void ZHR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_ZHR);
        startActivity(intent);
    }
    public void MTR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_MTR);
        startActivity(intent);
    }
    public void PKP(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_PKP);
        startActivity(intent);
    }
    public void BBD(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_BBD);
        startActivity(intent);
    }
    public void BSR(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_BSR);
        startActivity(intent);
    }
    public void COXS(View v) {
        Intent intent = new Intent(this, SearchMainActivity.class);
        intent.putExtra("base_id", AppConstant.BAF_COXS);
        startActivity(intent);
    }
    public void UNIT(View v) {
        dataBaseUtility.getSqnUnitData(mContext,"2");
        Intent intent = new Intent(this, UnitDetailActivity.class);
        intent.putExtra("header","UNITS");
        startActivity(intent);
    }
    public void SQN(View v) {
        dataBaseUtility.getSqnUnitData(mContext,"1");
        Intent intent = new Intent(this, UnitDetailActivity.class);
        intent.putExtra("header","SQUADRON");
        startActivity(intent);
    }


    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImageUrlFormLocalRes() {

        HashMapForLocalRes = new HashMap<String, Integer>();
        HashMapForLocalRes.put("MIG 29", R.drawable.banner1);
        HashMapForLocalRes.put("MI 17 SHA", R.drawable.banner2);
        HashMapForLocalRes.put("C 130", R.drawable.banner3);
        HashMapForLocalRes.put("F7 BG", R.drawable.banner4);
        HashMapForLocalRes.put("K8W", R.drawable.banner5);
        HashMapForLocalRes.put("L 410", R.drawable.banner6);
        HashMapForLocalRes.put("PT 6", R.drawable.banner7);
        HashMapForLocalRes.put("AW 139", R.drawable.banner8);
        HashMapForLocalRes.put("AN 32", R.drawable.banner9);

    }




    /********************************More Menu****************/
    public void HOME(View v) {
        Intent intent = new Intent(this, PdfMainActivity.class);
        startActivity(intent);
    }

    public void LOCATION(View v) {




        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            dataBaseUtility.getLocationData(mContext);
            Intent intent = new Intent(this, LocationMapActivity.class);
            startActivity(intent);
        }else
        {
            showGPSDiabledDialog();
        }

    }
    public void VIDEO(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/channel/UC7L-FsmHK9MNDZhNdEDq1LQ"));
        startActivity(intent);
    }
    public void WEB(View v) {
        Intent intent = new Intent(this, WebsiteActivity.class);
        startActivity(intent);
    }
    public void MENU(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }



    public void showGPSDiabledDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GPS Disabled");
        builder.setMessage("Gps is disabled, in order to use the application properly you need to enable GPS of your device");
        builder.setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), GPS_ENABLE_REQUEST);
            }
        }).setNegativeButton("No, Just Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        mGPSDialog = builder.create();
        mGPSDialog.show();
    }

}
