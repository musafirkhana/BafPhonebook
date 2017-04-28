package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.adapter.SupportAdapter;
import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.model.ContactListModel;

public class ContactListActivity extends Activity {
    private Context mContext;
    private SupportAdapter supportAdapter;
    public EditText mobile_no_search;
    private ListView mobile_no_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contactlist);
        mContext = this;
        Header=getIntent().getStringExtra("header");
        initUI();
    }

private void initUI(){
    topbar=(TextView)findViewById(R.id.topbar);
    topbar.setText(Header);
    mobile_no_search = (EditText) findViewById(R.id.mobile_no_search);
    mobile_no_list = (ListView) findViewById(R.id.mobile_no_list);
    supportAdapter = new SupportAdapter(this);
    mobile_no_list.setAdapter(supportAdapter);
    mobile_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           /* ContactListModel query= AllContactListVector.getAllContactlist().elementAt(position);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+""+query.getMobileno()));
            startActivity(callIntent);*/
            ContactListModel query= AllContactListVector.getAllContactlist().elementAt(position);
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("header",""+query.getMobileno());
            intent.putExtra("name",""+query.getDesignation());
            startActivity(intent);

        }
    });
    // TextFilter
    mobile_no_list.setTextFilterEnabled(true);

    mobile_no_search.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            if (count < before) {
                // We're deleting char so we need to reset the adapter data
                supportAdapter.resetData();
            }

            supportAdapter.getFilter().filter(s.toString());

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
