package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.mtr.MtrMainActivity;
import com.baf.musafir.bafphonebook.pkp.PkpMainActivity;
import com.baf.musafir.bafphonebook.util.*;
import com.baf.musafir.bafphonebook.util.AppConstant;
import com.baf.musafir.bafphonebook.zhr.ZhrMainActivity;

public class SearchMainActivity extends Activity {
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private ToastUtil toastUtil;

    private RelativeLayout detail_relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_main);
        mContext = this;
        toastUtil = new ToastUtil(this);
        baseID = getIntent().getStringExtra("base_id");
        dataBaseUtility = new DataBaseUtility();
        detail_relative=(RelativeLayout)findViewById(R.id.detail_relative);
       if(baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)){
           detail_relative.setVisibility(View.GONE);
       }
    }

    public void HOME(View v) {
        this.finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void MOBILE(View v) {
        if (baseID.equalsIgnoreCase(AppConstant.BAF_AHQ)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "AHQ SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_ZHR)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "ZHR SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_MTR)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "MTR SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BSR)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "BSR SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_COXS)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "COXS SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BBD)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "BBD SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_PKP)) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "PKP SEARCH");
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)) {
            dataBaseUtility.getAllMobileData(mContext);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
        }


    }

    /*****************************************************************
     * This Method is used for separate Different Base Data
     * By selecting any of the base ID one can get only corrosponding base data
     * Like if we select BASEID=2 that means ZHR base is selected
     * @param v
     *************************************/
    public void PABX(View v) {
        if (baseID.equalsIgnoreCase(AppConstant.BAF_AHQ)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "AHQ");
           // intent.putExtra("base_id", baseID);
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_ZHR)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "ZHR");
           // intent.putExtra("base_id", baseID);
            startActivity(intent);
            this.finish();
        }  else if (baseID.equalsIgnoreCase(AppConstant.BAF_MTR)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "MTR");
            //intent.putExtra("base_id", baseID);
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_PKP)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "PKP");
            //intent.putExtra("base_id", baseID);
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BSR)) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "BSR");
                startActivity(intent);
                this.finish();
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_COXS)) {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
                /*dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "COXS SEARCH");
                startActivity(intent);
                this.finish();*/
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BBD)) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "BBD");
                startActivity(intent);
                this.finish();
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)) {
            dataBaseUtility.getAllData(mContext);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
            this.finish();
        }


    }





    public void DETAIL(View v) {

        if (baseID.equalsIgnoreCase("2")) {
            //dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, ZhrMainActivity.class);
            intent.putExtra("header", "ZHR");
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        }  else if (baseID.equalsIgnoreCase("3")) {
            //dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MtrMainActivity.class);
            intent.putExtra("header", "MTR");
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase("7")) {
            //dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, PkpMainActivity.class);
            intent.putExtra("header", "PKP");
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase("4")) {
            if (AllPabxListVector.getAllPabxlist().size() > 0) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "BSR SEARCH");
                startActivity(intent);
                this.finish();
            } else {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
            }
        } else if (baseID.equalsIgnoreCase("5")) {
            if (AllPabxListVector.getAllPabxlist().size() > 0) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "COXS SEARCH");
                startActivity(intent);
                this.finish();
            } else {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
            }
        } else if (baseID.equalsIgnoreCase("6")) {
            if (AllPabxListVector.getAllPabxlist().size() > 0) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "BBD SEARCH");
                startActivity(intent);
                this.finish();
            } else {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
            }
        } else if (baseID.equalsIgnoreCase("10")) {
            dataBaseUtility.getAllData(mContext);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
            this.finish();
        }


    }
}
