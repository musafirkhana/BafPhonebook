package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.adapter.DetailAdapter;
import com.baf.musafir.bafphonebook.adapter.DetailListAdapter;
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllDetailListVector;
import com.baf.musafir.bafphonebook.holder.AllDetailVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.DetailListModel;
import com.baf.musafir.bafphonebook.model.DetailModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;
import com.baf.musafir.bafphonebook.util.AppConstant;

public class DetailBaseActivity extends Activity {
    private static String TAG = "DetailBaseActivity";
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private String baseID;

    private DetailAdapter detailAdapter;
    private SearchAdapter pabxAdapter;
    private DetailListAdapter detailListAdapter;

    private ListView detail_no_list;
    public EditText detail_search;
    public Spinner wing_spinner;
    public Spinner sqn_spinner;
    public TextView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail_base);
        mContext = this;
        baseID=getIntent().getStringExtra("base_id");
        dataBaseUtility = new DataBaseUtility();
        initUI();
        setHeader(baseID);
    }

    private void initUI() {

        // Get reference of SpinnerView from layout/main_activity.xml
        wing_spinner = (Spinner) findViewById(R.id.wing_spinner);
        sqn_spinner = (Spinner) findViewById(R.id.sqn_spinner);
        detailAdapter = new DetailAdapter(mContext, R.layout.row_detail);
        detailListAdapter = new DetailListAdapter(mContext, R.layout.row_list_detail);
        wing_spinner.setAdapter(detailAdapter);
        wing_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailModel query = AllDetailVector.getAllDetail().elementAt(position);
                callAgain("" + query.getBase_id(), "" + query.getWing_id());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void callAgain(String baseId, String sqnID) {
        dataBaseUtility.getPabxDataByBaseUniqueSqnID(mContext, baseId, sqnID);
        sqn_spinner.setAdapter(detailListAdapter);
        sqn_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailListModel query = AllDetailListVector.getAllDetaillist().elementAt(position);
                DetailList(query.getBase_id(), query.getWing_id(), query.getSqn_id());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void DetailList(String baseID, String wingID, String sqnID) {
        detail_search = (EditText) findViewById(R.id.detail_search);
        dataBaseUtility.getPabxDataForDetail(mContext, baseID, wingID, sqnID);
        detail_no_list = (ListView) findViewById(R.id.detail_no_list);
        pabxAdapter = new SearchAdapter(this);
        detail_no_list.setAdapter(pabxAdapter);
        detail_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
        // TextFilter
        detail_no_list.setTextFilterEnabled(true);
        detail_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    pabxAdapter.resetData();
                }
                pabxAdapter.getFilter().filter(s.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void BACK(View v){
        this.finish();
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
