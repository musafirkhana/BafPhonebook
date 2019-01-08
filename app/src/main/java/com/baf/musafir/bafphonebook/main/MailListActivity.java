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
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.PabxListModel;

public class MailListActivity extends Activity {
    private Context mContext;
    private EmailAdapter emailAdapter;
    public EditText email_search;
    private ListView email_no_list;
    private TextView topbar;
    private String Header = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mail_search);
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
        email_search = (EditText) findViewById(R.id.email_search);
        email_no_list = (ListView) findViewById(R.id.email_no_list);
        emailAdapter = new EmailAdapter(this);
        email_no_list.setAdapter(emailAdapter);
        email_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);


            }
        });
        // TextFilter
        email_no_list.setTextFilterEnabled(true);

        email_search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    emailAdapter.resetData();
                }

                emailAdapter.getFilter().filter(s.toString());

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
