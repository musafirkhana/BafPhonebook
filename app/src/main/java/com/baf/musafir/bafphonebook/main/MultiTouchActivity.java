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
        if(category.equalsIgnoreCase("1")){
            topbar.setText("AIR HQ ORG");
            touchImageView.setImageResource(R.drawable.airhqoeg);
        }else if(category.equalsIgnoreCase("2")){
            topbar.setText("OPS AND TRG BRANCH");
            touchImageView.setImageResource(R.drawable.opsandtrg);
        }else if(category.equalsIgnoreCase("3")){
            topbar.setText("ADMIN BRANCH");
            touchImageView.setImageResource(R.drawable.admin);
        }else if(category.equalsIgnoreCase("4")){
            topbar.setText("MAINTENANCE BRANCH");
            touchImageView.setImageResource(R.drawable.maintbranch);
        }else if(category.equalsIgnoreCase("5")){
            topbar.setText("FUNCTIONAL ORG");
            touchImageView.setImageResource(R.drawable.functionalorg);
        }

        touchImageView.setMaxZoom(6f);
    }

    public void BACK(View v) {
        this.finish();

    }
}
