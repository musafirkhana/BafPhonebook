package com.baf.musafir.bafphonebook.main;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.util.TouchImageView;

public class MultiTouchActivity extends Activity {
    private String category = "";
    private TextView topbar;
    private TouchImageView touchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.imageview_activity);
        topbar=(TextView)findViewById(R.id.topbar);

        category = getIntent().getStringExtra("cat");
       /* TouchImageView img = new TouchImageView(this);

        setContentView(img);*/
        touchImageView=(TouchImageView)findViewById(R.id.touch_imageview);


        touchImageView.setMaxZoom(6f);
    }

    public void BACK(View v) {
        this.finish();

    }
}
