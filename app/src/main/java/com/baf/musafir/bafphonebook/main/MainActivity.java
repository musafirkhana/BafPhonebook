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
import com.baf.musafir.bafphonebook.adapter.EmailAdapter;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.util.AppConstant;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.card.MaterialCardView;

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

    private MaterialCardView matcard_abbr;
    private MaterialCardView matcard_email;
    private MaterialCardView matcard_airhq;
    private MaterialCardView matcard_bsr;
    private MaterialCardView matcard_bbd;
    private MaterialCardView matcard_zhr;
    private MaterialCardView matcard_mtr;
    private MaterialCardView matcard_pkp;
    private MaterialCardView matcard_coxs;




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
        matcard_abbr=(MaterialCardView)findViewById(R.id.matcard_abbr);
        matcard_email=(MaterialCardView)findViewById(R.id.matcard_email);
        matcard_airhq=(MaterialCardView)findViewById(R.id.matcard_airhq);
        matcard_bsr=(MaterialCardView)findViewById(R.id.matcard_bsr);
        matcard_bbd=(MaterialCardView)findViewById(R.id.matcard_bbd);
        matcard_zhr=(MaterialCardView)findViewById(R.id.matcard_zhr);
        matcard_mtr=(MaterialCardView)findViewById(R.id.matcard_mtr);
        matcard_pkp=(MaterialCardView)findViewById(R.id.matcard_pkp);
        matcard_coxs=(MaterialCardView)findViewById(R.id.matcard_coxs);

        matcard_abbr.setOnClickListener(onclickListner);
        matcard_email.setOnClickListener(onclickListner);
        matcard_airhq.setOnClickListener(onclickListner);
        matcard_bsr.setOnClickListener(onclickListner);
        matcard_bbd.setOnClickListener(onclickListner);
        matcard_zhr.setOnClickListener(onclickListner);
        matcard_mtr.setOnClickListener(onclickListner);
        matcard_pkp.setOnClickListener(onclickListner);
        matcard_coxs.setOnClickListener(onclickListner);
    }





    public View.OnClickListener onclickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.matcard_abbr:
                    Intent intent = new Intent(mContext, GenerelAbbribiationActivity.class);
                    intent.putExtra("header","Abbreviation");
                    startActivity(intent);
                    break;

                case R.id.matcard_email:
                    dataBaseUtility.getAllEmailAddData(mContext);
                    Intent intentSearch = new Intent(mContext, MailListActivity.class);
                    startActivity(intentSearch);
                    break;

                case R.id.matcard_airhq:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_AHQ);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_AHQ);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_AHQ);
                    Intent intentAirhq = new Intent(mContext, SearchActivity.class);
                    intentAirhq.putExtra("base_id", AppConstant.BAF_AHQ);
                    intentAirhq.putExtra("header", AppConstant.BAF_AHQ_HEADER);
                    startActivity(intentAirhq);
                    break;

                case R.id.matcard_bsr:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_BSR);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_BSR);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_BSR);
                    Intent intentBsr = new Intent(mContext, SearchActivity.class);
                    intentBsr.putExtra("base_id", AppConstant.BAF_BSR);
                    intentBsr.putExtra("header", AppConstant.BAF_BSR_HEADER);
                    startActivity(intentBsr);
                    break;

                case R.id.matcard_bbd:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_BBD);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_BBD);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_BBD);
                    Intent intentBbd = new Intent(mContext, SearchActivity.class);
                    intentBbd.putExtra("base_id", AppConstant.BAF_BBD);
                    intentBbd.putExtra("header", AppConstant.BAF_BBD_HEADER);
                    startActivity(intentBbd);
                    break;

                case R.id.matcard_zhr:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_ZHR);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_ZHR);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_ZHR);
                    Intent intentZhr = new Intent(mContext, SearchActivity.class);
                    intentZhr.putExtra("base_id", AppConstant.BAF_ZHR);
                    intentZhr.putExtra("header", AppConstant.BAF_ZHR_HEADER);
                    startActivity(intentZhr);
                    break;

                case R.id.matcard_mtr:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_MTR);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_MTR);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_MTR);
                    Intent intentMtr = new Intent(mContext, SearchActivity.class);
                    intentMtr.putExtra("base_id", AppConstant.BAF_MTR);
                    intentMtr.putExtra("header", AppConstant.BAF_MTR_HEADER);
                    startActivity(intentMtr);
                    break;

                case R.id.matcard_pkp:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_PKP);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_PKP);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_PKP);
                    Intent intentPkp = new Intent(mContext, SearchActivity.class);
                    intentPkp.putExtra("base_id", AppConstant.BAF_PKP);
                    intentPkp.putExtra("header", AppConstant.BAF_PKP_HEADER);
                    startActivity(intentPkp);
                    break;

                case R.id.matcard_coxs:
                    dataBaseUtility.getPabxDataByBaseID(mContext, AppConstant.BAF_COXS);
                    dataBaseUtility.getAllMobileDataByBaseID(mContext, AppConstant.BAF_COXS);
                    dataBaseUtility.getPabxDataByBaseUniqueID(mContext, AppConstant.BAF_COXS);
                    Intent intentCoxs = new Intent(mContext, SearchActivity.class);
                    intentCoxs.putExtra("base_id", AppConstant.BAF_COXS);
                    intentCoxs.putExtra("header", AppConstant.BAF_COXS_HEADER);
                    startActivity(intentCoxs);
                    break;

                default:
                    break;

            }
        }
    };

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
        Intent intent = new Intent(this, WebMainActivity.class);
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
