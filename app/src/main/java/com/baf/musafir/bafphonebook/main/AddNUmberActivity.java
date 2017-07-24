package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.AssetDatabaseOpenHelper;
import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.util.JustifiedTextView;
import com.baf.musafir.bafphonebook.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/***************************
 * copyright@ Musafir Ali
 * Bangladesh Airforce
 */
public class AddNUmberActivity extends Activity implements View.OnClickListener {
    private String TAG = "AddNUmberActivity";
    private Context mContext;
    private ToastUtil toastUtil;
    List<String> list = new ArrayList<String>();

    /********************
     * UI Decleration
     *******************/
    private Spinner base_spinner;
    private EditText edt_designation;
    private EditText edt_mobile_no;
    private Button btn_cancel;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_addnumber);
        mContext = this;
        toastUtil = new ToastUtil(this);
        initUI();
    }

    private void initUI() {
        base_spinner = (Spinner) findViewById(R.id.base_spinner);
        edt_designation = (EditText) findViewById(R.id.edt_designation);
        edt_mobile_no = (EditText) findViewById(R.id.edt_mobile_no);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_save = (Button) findViewById(R.id.btn_save);

        btn_cancel.setOnClickListener(this);
        btn_save.setOnClickListener(this);


        list.add("* SELECT BASE");
        list.add("AHQ");
        list.add("ZHR");
        list.add("MTR");
        list.add("BSR");
        list.add("CXB");
        list.add("KTL");
        list.add("PKP");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.salutation, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        base_spinner.setAdapter(dataAdapter);
        base_spinner.setSelection(0);
        base_spinner.setFocusable(true);
        base_spinner.setFocusableInTouchMode(true);
        base_spinner.requestFocus();

        base_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                base_spinner.clearFocus();
                toastUtil.appSuccessMsg(mContext, base_spinner.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    public void HOME(View v) {
        this.finish();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                this.finish();
                toastUtil.appSuccessMsg(mContext, "Cancel");
                break;
            case R.id.btn_save:

                if(base_spinner.getSelectedItem().toString().equalsIgnoreCase("* SELECT BASE")){
                    toastUtil.appSuccessMsg(mContext, "Please Select a base");
                }else if (edt_designation.getText().toString().equalsIgnoreCase("")) {
                    edt_mobile_no.requestFocus();
                    edt_designation.setError("Designation Required ");
                } else if (edt_mobile_no.getText().toString().equalsIgnoreCase("")) {
                    edt_mobile_no.requestFocus();
                    edt_mobile_no.setError("Mobile Number Required ");
                } else {
                    insertData(base_spinner.getSelectedItem().toString(), edt_designation.getText().toString().trim(),
                            edt_mobile_no.getText().toString().trim());
                    this.finish();
                }


                break;
        }
    }

    private void insertData(String baseName, String designationString, String number) {
        AssetDatabaseOpenHelper databaseOpenHelper = new AssetDatabaseOpenHelper(mContext);
        SQLiteDatabase db = databaseOpenHelper.openDatabase();
        db.beginTransaction();

        String strSQL = "INSERT INTO `mobile_no`(`designation`,`mobile_no`,`base_id`,`base_name`,`sqn_id`,`sqn_name`,`wing_id`,`wing_name`) VALUES ('" +
                designationString +
                "','" +
                number +
                "','" +
                getBaseID(baseName) +
                "','" +
                baseName +
                "',NULL,NULL,NULL,NULL);";
        db.execSQL(strSQL);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

        toastUtil.appSuccessMsg(mContext, "Data Insert Duccessfully");

    }

    private String getBaseID(String baseName) {
        String baseID = "";
        if (baseName.equalsIgnoreCase("AHQ")) {
            baseID = "1";
        } else if (baseName.equalsIgnoreCase("ZHR")) {
            baseID = "2";
        } else if (baseName.equalsIgnoreCase("MTR")) {
            baseID = "3";
        } else if (baseName.equalsIgnoreCase("BSR")) {
            baseID = "4";
        } else if (baseName.equalsIgnoreCase("CXB")) {
            baseID = "5";
        } else if (baseName.equalsIgnoreCase("KTL")) {
            baseID = "6";
        }else if (baseName.equalsIgnoreCase("PKP")) {
            baseID = "7";
        }

        return baseID;

    }
}
