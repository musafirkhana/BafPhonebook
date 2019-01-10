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

public class DetailBaseActivity extends Activity  {
    private static String TAG = "DetailBaseActivity";
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
    private DetailAdapter detailAdapter;
    private SearchAdapter pabxAdapter;
    private DetailListAdapter detailListAdapter;
    private ListView detail_no_list;
    public EditText detail_search;
    Spinner spinnerDropDown;
    Spinner spinnerDropDown2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail_base);
        mContext = this;
        dataBaseUtility = new DataBaseUtility();
        initUI();
    }

    private void initUI() {



        // Get reference of SpinnerView from layout/main_activity.xml
        spinnerDropDown =(Spinner)findViewById(R.id.spinner1);
        spinnerDropDown2 =(Spinner)findViewById(R.id.spinner2);
        detailAdapter=new DetailAdapter(mContext,R.layout.row_detail);
        detailListAdapter=new DetailListAdapter(mContext,R.layout.row_list_detail);
        /*ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item ,cities);*/

        spinnerDropDown.setAdapter(detailAdapter);
        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailModel query= AllDetailVector.getAllDetail().elementAt(position);
                Log.w(TAG, "getAirHqLodgerData: " + query.getWing_id());
                Log.w(TAG, "getAirHqLodgerData: " + query.getSqn_name());
                Log.w(TAG, "getAirHqLodgerData: " + query.getWing_id());
                callAgain(""+query.getBase_id(),""+query.getWing_id());
                Toast.makeText(getBaseContext(), "You have selected City : " + query.getSqn_name(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });




    }
    public void callAgain(String baseId,String sqnID){
dataBaseUtility.getPabxDataByBaseUniqueSqnID(mContext,baseId,sqnID);

        spinnerDropDown2.setAdapter(detailListAdapter);
        spinnerDropDown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailListModel query= AllDetailListVector.getAllDetaillist().elementAt(position);
                DetailList(query.getBase_id(),query.getWing_id(),query.getSqn_id());
                Toast.makeText(getBaseContext(), "You have selected SQN : " + query.getSqn_name(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void DetailList(String baseID,String wingID,String sqnID){
        detail_search=(EditText)findViewById(R.id.detail_search);
        dataBaseUtility.getPabxDataForDetail(mContext, baseID,wingID,sqnID);
        detail_no_list=(ListView) findViewById(R.id.detail_no_list);;
        pabxAdapter = new SearchAdapter(this);
        detail_no_list.setAdapter(pabxAdapter);
        detail_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);


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
}
