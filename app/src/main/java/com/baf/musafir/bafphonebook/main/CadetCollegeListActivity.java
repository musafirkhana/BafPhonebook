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
import com.baf.musafir.bafphonebook.adapter.CadetCollegeAdapter;
import com.baf.musafir.bafphonebook.holder.AllCadetCollegeListVector;
import com.baf.musafir.bafphonebook.model.CadetCollegeListModel;

public class CadetCollegeListActivity extends Activity {
    private Context mContext;
    private CadetCollegeAdapter cadetCollegeAdapter;
    public EditText mobile_no_search;
    private ListView cc_no_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cclist);
        mContext = this;
        Header=getIntent().getStringExtra("header");
        initUI();
    }
    public void BACK(View v) {
        this.finish();


    }
private void initUI(){
    topbar=(TextView)findViewById(R.id.topbar);
    topbar.setText(Header);
    mobile_no_search = (EditText) findViewById(R.id.mobile_no_search);
    cc_no_list = (ListView) findViewById(R.id.cc_no_list);
    cadetCollegeAdapter = new CadetCollegeAdapter(this);
    cc_no_list.setAdapter(cadetCollegeAdapter);
    cc_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           /* ContactListModel query= AllContactListVector.getAllContactlist().elementAt(position);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+""+query.getMobileno()));
            startActivity(callIntent);*/
            CadetCollegeListModel query= AllCadetCollegeListVector.getAllCadetCollegelist().elementAt(position);
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("header",""+query.getMobile_no());
            intent.putExtra("name",""+query.getDesignation());
            startActivity(intent);

        }
    });
    // TextFilter
    cc_no_list.setTextFilterEnabled(true);

    mobile_no_search.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            if (count < before) {
                // We're deleting char so we need to reset the adapter data
                cadetCollegeAdapter.resetData();
            }

            cadetCollegeAdapter.getFilter().filter(s.toString());

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
