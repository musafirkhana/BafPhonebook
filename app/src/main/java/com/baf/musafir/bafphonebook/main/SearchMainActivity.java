package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.util.*;
import com.baf.musafir.bafphonebook.util.AppConstant;

public class SearchMainActivity extends Activity {
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private String baseID = "";
    private ToastUtil toastUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_main);
        mContext = this;
        toastUtil = new ToastUtil(this);
        baseID = getIntent().getStringExtra("base_id");
        dataBaseUtility = new DataBaseUtility();
    }

    public void HOME(View v) {
        this.finish();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    public void MOBILE(View v) {
        if (baseID.equalsIgnoreCase("2")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "ZHR SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("3")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "MTR SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("4")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "BSR SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("5")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "COXS SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("6")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "BBD SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("7")) {
            dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "PKP SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("0")) {

            dataBaseUtility.getAllMobileData(mContext);
            Intent intent = new Intent(this, MobileSearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
            this.finish();
        }


    }

    public void PABX(View v) {

        if (baseID.equalsIgnoreCase("2")) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "ZHR SEARCH");
            startActivity(intent);
            this.finish();
        } else if (baseID.equalsIgnoreCase("3")) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "MTR SEARCH");
            startActivity(intent);
            this.finish();
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
        } else if (baseID.equalsIgnoreCase("7")) {
            if (AllPabxListVector.getAllPabxlist().size() > 0) {
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                Intent intent = new Intent(this, SearchListActivity.class);
                intent.putExtra("header", "PKP SEARCH");
                startActivity(intent);
                this.finish();
            } else {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
            }
        } else if (baseID.equalsIgnoreCase("0")) {
            dataBaseUtility.getAllData(mContext);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
            this.finish();
        }


    }


}
