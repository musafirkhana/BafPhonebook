package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.util.JustifiedTextView;

public class HistoryActivity extends Activity {
private Context mContext;
    private JustifiedTextView history_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_history);
        mContext=this;
        history_text= (JustifiedTextView) findViewById(R.id.history_text);
        history_text.setText(getResources().getString(R.string.airforcr_history));
        history_text.setTextColor(R.color.white);
        history_text.setAlignment(Paint.Align.LEFT);
        history_text.setTextSize(0,60);
    }

public void HOME(View v){
    this.finish();

}


}
