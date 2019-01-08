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
import com.baf.musafir.bafphonebook.adapter.OthersAdapter;
import com.baf.musafir.bafphonebook.holder.AllOthersListVector;
import com.baf.musafir.bafphonebook.model.OthersListModel;

public class OthersListActivity extends Activity {
    private Context mContext;
    private OthersAdapter othersAdapter;
    public EditText others_search;
    private ListView others_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_otherslist);
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
    others_search = (EditText) findViewById(R.id.others_search);
    others_list = (ListView) findViewById(R.id.others_list);
    othersAdapter = new OthersAdapter(this);
    others_list.setAdapter(othersAdapter);
    /*others_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            OthersListModel query= AllOthersListVector.getAllOtherslist().elementAt(position);
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("header",""+query.getNumber());
            intent.putExtra("name",""+query.getDesignation());
            startActivity(intent);

        }
    });*/
    // TextFilter
    others_list.setTextFilterEnabled(true);

    others_search.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            if (count < before) {
                // We're deleting char so we need to reset the adapter data
                othersAdapter.resetData();
            }

            othersAdapter.getFilter().filter(s.toString());

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
