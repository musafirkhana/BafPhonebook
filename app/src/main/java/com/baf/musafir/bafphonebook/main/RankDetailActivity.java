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
import com.baf.musafir.bafphonebook.adapter.RankAdapter;
import com.baf.musafir.bafphonebook.holder.AllMobileListVector;
import com.baf.musafir.bafphonebook.model.MobileListModel;

/*****************************
 * Search All Mobile No
 *****************************/
public class RankDetailActivity extends Activity {
    private Context mContext;
    private RankAdapter rankAdapter;
    private ListView rankdetail_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rank_detail);
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
    rankdetail_list = (ListView) findViewById(R.id.rankdetail_list);
    rankAdapter = new RankAdapter(this);
    rankdetail_list.setAdapter(rankAdapter);



}


}
