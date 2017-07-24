package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.baf.musafir.bafphonebook.adapter.AbbrAdapter;
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class GenerelAbbribiationActivity extends Activity {
    private Context mContext;
    private AbbrAdapter abbrAdapter;
    public EditText mobile_no_search;
    private ListView abbr_list;
    private TextView topbar;
    private String Header = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_geabbr);
        mContext = this;
        Header = getIntent().getStringExtra("header");

        initUI();
    }
    public void HOME(View v) {
        this.finish();
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);

    }
    private void initUI() {
        topbar = (TextView) findViewById(R.id.topbar);
        topbar.setText(Header);
        mobile_no_search = (EditText) findViewById(R.id.mobile_no_search);
        abbr_list = (ListView) findViewById(R.id.abbr_list);
        abbrAdapter = new AbbrAdapter(this);
        abbr_list.setAdapter(abbrAdapter);

        // TextFilter
        abbr_list.setTextFilterEnabled(true);

        mobile_no_search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    abbrAdapter.resetData();
                }

                abbrAdapter.getFilter().filter(s.toString());

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
