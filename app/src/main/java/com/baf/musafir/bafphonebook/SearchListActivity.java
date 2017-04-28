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

import com.baf.musafir.bafphonebook.adapter.PabxAdapter;
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class SearchListActivity extends Activity {
    private Context mContext;
    private SearchAdapter pabxAdapter;
    public EditText mobile_no_search;
    private ListView pabx_no_list;
    private TextView topbar;
    private String Header = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        mContext = this;
        Header = getIntent().getStringExtra("header");

        initUI();
    }

    private void initUI() {
        topbar = (TextView) findViewById(R.id.topbar);
        topbar.setText(Header);
        mobile_no_search = (EditText) findViewById(R.id.mobile_no_search);
        pabx_no_list = (ListView) findViewById(R.id.pabx_no_list);
        pabxAdapter = new SearchAdapter(this);
        pabx_no_list.setAdapter(pabxAdapter);
        pabx_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);


            }
        });
        // TextFilter
        pabx_no_list.setTextFilterEnabled(true);

        mobile_no_search.addTextChangedListener(new TextWatcher() {

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
