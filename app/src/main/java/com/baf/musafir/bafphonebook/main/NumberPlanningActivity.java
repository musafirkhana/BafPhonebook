package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.adapter.EmailAdapter;
import com.baf.musafir.bafphonebook.adapter.NumberPlanAdapter;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class NumberPlanningActivity extends Activity {
    private Context mContext;
    private NumberPlanAdapter numberPlanAdapter;
    public EditText numberplan_search;
    private ListView number_plan_no_list;
    private TextView topbar;
    private String Header = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_numberplanning);
        mContext = this;
        Header = getIntent().getStringExtra("header");

        initUI();
    }

    public void BACK(View v) {
        this.finish();
    }

    private void initUI() {
        topbar = (TextView) findViewById(R.id.topbar);
        topbar.setText(Header);
        numberplan_search = (EditText) findViewById(R.id.numberplan_search);
        number_plan_no_list = (ListView) findViewById(R.id.number_plan_no_list);
        numberPlanAdapter = new NumberPlanAdapter(this);
        number_plan_no_list.setAdapter(numberPlanAdapter);
        number_plan_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);


            }
        });
        // TextFilter
        number_plan_no_list.setTextFilterEnabled(true);

        numberplan_search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    numberPlanAdapter.resetData();
                }

                numberPlanAdapter.getFilter().filter(s.toString());

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
