package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.adapter.DetailAdapter;
import com.baf.musafir.bafphonebook.adapter.DetailListAdapter;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class DetailBaseActivity extends Activity  {
    private static String TAG = "DetailBaseActivity";
    private Context mContext;
    private DataBaseUtility dataBaseUtility;
private DetailAdapter detailAdapter;
    private DetailListAdapter detailListAdapter;
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
                PabxListModel query= AllPabxListVector.getAllPabxlist().elementAt(position);
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
                PabxListModel query= AllPabxListVector.getAllPabxlist().elementAt(position);

                Toast.makeText(getBaseContext(), "You have selected SQN : " + query.getSqn_name(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}
