package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private TextView topbar;
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
        detail_relative = (RelativeLayout) findViewById(R.id.detail_relative);
        if (baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)) {
            detail_relative.setVisibility(View.GONE);
        }
        setHeader(baseID);
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
            intent.putExtra("header", AppConstant.BAF_AHQ_HEADER);
            // intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_ZHR)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", AppConstant.BAF_ZHR_HEADER);
            // intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_MTR)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", AppConstant.BAF_MTR_HEADER);
            //intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_PKP)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", AppConstant.BAF_PKP_HEADER);
            //intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BSR)) {
            dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", AppConstant.BAF_BSR_HEADER);
            startActivity(intent);
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
            intent.putExtra("header", AppConstant.BAF_BBD_HEADER);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)) {
            dataBaseUtility.getAllData(mContext);
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("header", "SEARCH");
            startActivity(intent);
        }


    }


    public void DETAIL(View v) {

        if (baseID.equalsIgnoreCase(AppConstant.BAF_ZHR)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_MTR)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_PKP)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BSR)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BBD)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);

        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_AHQ)) {
            dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
            Intent intent = new Intent(this, DetailBaseActivity.class);
            intent.putExtra("base_id", baseID);
            startActivity(intent);

        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_COXS)) {
            if (AllPabxListVector.getAllPabxlist().size() > 0) {
                dataBaseUtility.getPabxDataByBaseUniqueID(mContext, baseID);
                Intent intent = new Intent(this, DetailBaseActivity.class);
                intent.putExtra("base_id", baseID);
                startActivity(intent);
            } else {
                toastUtil.appSuccessMsg(mContext, AppConstant.NO_DATA);
            }
        }


    }


    public void setHeader(String baseID){
        topbar=(TextView)findViewById(R.id.topbar);
        if (baseID.equalsIgnoreCase(AppConstant.BAF_AHQ)) {
            topbar.setText(AppConstant.BAF_AHQ_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_ZHR)) {
            topbar.setText(AppConstant.BAF_ZHR_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_MTR)) {
            topbar.setText(AppConstant.BAF_MTR_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_PKP)) {
            topbar.setText(AppConstant.BAF_PKP_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BSR)) {
            topbar.setText(AppConstant.BAF_BSR_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_COXS)) {
            topbar.setText(AppConstant.BAF_COXS_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_BBD)) {
            topbar.setText(AppConstant.BAF_BBD_HEADER);
        } else if (baseID.equalsIgnoreCase(AppConstant.BAF_SEARCH)) {
            topbar.setText(AppConstant.BAF_SEARCH_HEADER);
        }
    }
}
