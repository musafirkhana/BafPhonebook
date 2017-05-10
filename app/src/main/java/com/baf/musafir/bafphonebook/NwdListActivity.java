package com.baf.musafir.bafphonebook;

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

import com.baf.musafir.bafphonebook.adapter.NwdAdapter;
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class NwdListActivity extends Activity {
    private Context mContext;
    private NwdAdapter nwdAdapter;
    public EditText txt_areasearch;
    private ListView area_list;
    private TextView topbar;
    private String Header = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_nwd);
        mContext = this;
        Header = getIntent().getStringExtra("header");

        initUI();
    }

    private void initUI() {
        topbar = (TextView) findViewById(R.id.topbar);
        topbar.setText(Header);
        txt_areasearch = (EditText) findViewById(R.id.txt_areasearch);
        area_list = (ListView) findViewById(R.id.area_list);
        nwdAdapter = new NwdAdapter(this);
        area_list.setAdapter(nwdAdapter);
        area_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);


            }
        });
        // TextFilter
        area_list.setTextFilterEnabled(true);

        txt_areasearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    nwdAdapter.resetData();
                }

                nwdAdapter.getFilter().filter(s.toString());

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
