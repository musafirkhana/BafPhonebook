package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.util.TouchImageView;
import com.squareup.picasso.Picasso;

public class RadarViewActivity extends Activity {
private Context mContext;
private TouchImageView radar_image;
private String imageUrl="https://wx.baf.mil.bd/METBSR/images/omar/RadarSingle/mtr.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_radar_view);
        mContext=this;
        initUI();
    }
    private void initUI(){
        radar_image=(TouchImageView)findViewById(R.id.radar_image);
       // Picasso.with(mContext).load("https://wx.baf.mil.bd/METBSR/images/omar/RadarSingle/mtr.jpg").into(radar_image);
        Picasso.with( mContext )
                .load( imageUrl )
                .error( R.drawable.ic_launcher )
                .placeholder( R.drawable.progress_animation )
                .into( radar_image );
        //radar_image.setZoom(100);
    }

    public void RELOAD(View v) {
        Picasso.with(mContext).invalidate(imageUrl);
        Picasso.with( mContext )
                .load( imageUrl )
                .error( R.drawable.ic_launcher )
                .placeholder( R.drawable.progress_animation )
                .into( radar_image );


    }



}
