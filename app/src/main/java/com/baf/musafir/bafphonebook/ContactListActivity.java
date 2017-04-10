package com.baf.musafir.bafphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;

import com.baf.musafir.bafphonebook.adapter.SupportAdapter;
import com.baf.musafir.bafphonebook.holder.AllContactListVector;

import static com.baf.musafir.bafphonebook.R.id.glosary_list;
import static com.baf.musafir.bafphonebook.R.id.glosaryedit_seach;

public class ContactListActivity extends Activity {
    private Context mContext;
    private SupportAdapter supportAdapter;
    public EditText glosaryedit_seach;
    ListView glosary_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contactlist);
        mContext = this;
        initUI();
    }

private void initUI(){
    glosaryedit_seach = (EditText) findViewById(R.id.glosaryedit_seach);
    glosary_list = (ListView) findViewById(R.id.glosary_list);
    supportAdapter = new SupportAdapter(this);
    glosary_list.setAdapter(supportAdapter);

    // TextFilter
    glosary_list.setTextFilterEnabled(true);

    glosaryedit_seach.addTextChangedListener(new TextWatcher() {

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
