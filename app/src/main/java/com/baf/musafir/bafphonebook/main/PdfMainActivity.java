package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;

public class PdfMainActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pdf_main);
        mContext=this;

    }
    public void PDF1(View v) {

        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra("pdfName","SOHBAIR.pdf");
        startActivity(intent);
    }

    public void PDF2(View v) {

        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra("pdfName","SEC-1.pdf");
        startActivity(intent);
    }

    public void PDF3(View v) {
        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra("pdfName","SEC2.pdf");
        startActivity(intent);
    }
    public void PDF4(View v) {
        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra("pdfName","SEC3.pdf");
        startActivity(intent);
    }
  /*  public void PDF5(View v) {
        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra("pdfName","baf_list.pdf");
        startActivity(intent);
    }*/
    public void BACK(View v){
        this.finish();

    }

}
