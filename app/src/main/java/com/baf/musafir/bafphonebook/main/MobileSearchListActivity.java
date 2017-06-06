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
import com.baf.musafir.bafphonebook.adapter.MobileSearchAdapter;
import com.baf.musafir.bafphonebook.holder.AllMobileListVector;
import com.baf.musafir.bafphonebook.model.MobileListModel;

/*****************************
 * Search All Mobile No
 *****************************/
public class MobileSearchListActivity extends Activity {
    private Context mContext;
    private MobileSearchAdapter mobileSearchAdapter;
    public EditText mobile_no_search;
    private ListView mobile_no_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mobile_searchlist);
        mContext = this;
        Header=getIntent().getStringExtra("header");
        initUI();
    }
    public void HOME(View v) {
        this.finish();
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);

    }

private void initUI(){
    topbar=(TextView)findViewById(R.id.topbar);
    topbar.setText(Header);
    mobile_no_search = (EditText) findViewById(R.id.mobile_no_search);
    mobile_no_list = (ListView) findViewById(R.id.mobile_no_list);
    mobileSearchAdapter = new MobileSearchAdapter(this);
    mobile_no_list.setAdapter(mobileSearchAdapter);
    mobile_no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           /* ContactListModel query= AllContactListVector.getAllContactlist().elementAt(position);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+""+query.getMobileno()));
            startActivity(callIntent);*/
            MobileListModel query= AllMobileListVector.getAllMobilelist().elementAt(position);
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
                mobileSearchAdapter.resetData();
            }

            mobileSearchAdapter.getFilter().filter(s.toString());

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
