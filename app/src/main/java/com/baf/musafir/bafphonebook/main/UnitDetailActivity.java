package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.adapter.RankAdapter;
import com.baf.musafir.bafphonebook.adapter.UnitAdapter;

/*****************************
 * Search All Mobile No
 *****************************/
public class UnitDetailActivity extends Activity {
    private Context mContext;
    private UnitAdapter unitAdapter;
    private ListView unit_list;
    private TextView topbar;
    private String Header="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_unit_detail);
        mContext = this;
        Header=getIntent().getStringExtra("header");
        initUI();
    }
    public void HOME(View v) {
        this.finish();


    }

private void initUI(){
    topbar=(TextView)findViewById(R.id.topbar);
    topbar.setText(Header);
    unit_list = (ListView) findViewById(R.id.unit_list);
    unitAdapter = new UnitAdapter(this);
    unit_list.setAdapter(unitAdapter);



}


}
