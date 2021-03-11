package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.adapter.DetailAdapter;
import com.baf.musafir.bafphonebook.adapter.DetailListAdapter;
import com.baf.musafir.bafphonebook.adapter.MobileSearchAdapter;
import com.baf.musafir.bafphonebook.adapter.SearchAdapter;
import com.baf.musafir.bafphonebook.databse.AssetDatabaseOpenHelper;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllDetailListVector;
import com.baf.musafir.bafphonebook.holder.AllDetailVector;
import com.baf.musafir.bafphonebook.holder.AllMobileListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.DetailListModel;
import com.baf.musafir.bafphonebook.model.DetailModel;
import com.baf.musafir.bafphonebook.model.MobileListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;
import com.baf.musafir.bafphonebook.util.AppConstant;
import com.baf.musafir.bafphonebook.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{
    private static String TAG = "SearchActivity";
    private Context mContext;
    private SearchAdapter pabxAdapter;
    private MobileSearchAdapter mobileSearchAdapter;
    private DetailAdapter detailAdapter;
    private DetailListAdapter detailListAdapter;
    private ToastUtil toastUtil;
    private DataBaseUtility dataBaseUtility;
    private int swnPosition=0;
    private String Header = "";
    private String baseID = "";
    List<String> list = new ArrayList<String>();

    AssetDatabaseOpenHelper databaseOpenHelper ;
    SQLiteDatabase db ;

    public EditText edt_search;
    private ListView data_list;
    private TextView topbar;
    private LinearLayout header_linear;
    private LinearLayout li_filter;
    private RelativeLayout search_li_back;
    private LinearLayout li_all;
    private ImageView btn_addnew;


    private RadioGroup radioGroup;
    private RadioButton rb_mobile, rb_pabx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_new);
        mContext = this;
        toastUtil=new ToastUtil(this);
        dataBaseUtility = new DataBaseUtility();
        Header = getIntent().getStringExtra("header");
        baseID = getIntent().getStringExtra("base_id");
        databaseOpenHelper = new AssetDatabaseOpenHelper(mContext);
        db = databaseOpenHelper.openDatabase();
        initUI();
        list.add("Air Headquarter");
        list.add("ZHR");
        list.add("MTR");
        list.add("BSR");
        list.add("CXB");
        list.add("BBD");
        list.add("PKP");
    }
    public void BACK(View v) {
        this.finish();
    }

    private void initUI() {
        topbar = (TextView) findViewById(R.id.topbar);
        btn_addnew=(ImageView)findViewById(R.id.btn_addnew);
        topbar.setText(Header);

        edt_search = (EditText) findViewById(R.id.edt_search);
        data_list = (ListView) findViewById(R.id.data_list);

        header_linear=(LinearLayout)findViewById(R.id.header_linear);
        li_filter=(LinearLayout)findViewById(R.id.li_filter);
        li_all=(LinearLayout)findViewById(R.id.li_all);
        search_li_back=(RelativeLayout)findViewById(R.id.search_li_back);

        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        rb_mobile = (RadioButton) findViewById(R.id.rb_mobile);
        rb_pabx = (RadioButton) findViewById(R.id.rb_pabx);

        detailAdapter = new DetailAdapter(mContext, R.layout.row_detail);
        detailListAdapter = new DetailListAdapter(mContext, R.layout.row_list_detail);

        radioGroup.setOnCheckedChangeListener(this);
        li_filter.setOnClickListener(this);
        li_all.setOnClickListener(this);
        search_li_back.setOnClickListener(this);
        btn_addnew.setOnClickListener(this);
        rb_pabx.setChecked(true);
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_mobile:

                header_linear.setVisibility(View.GONE);
                li_filter.setVisibility(View.GONE);
                li_all.setVisibility(View.GONE);
                setMobileList();

                break;
            case R.id.rb_pabx:
                header_linear.setVisibility(View.VISIBLE);
                li_filter.setVisibility(View.VISIBLE);
                li_all.setVisibility(View.VISIBLE);
                setPabxList();
                break;

        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.li_filter:
                showCustomDialog();
                break;
            case R.id.li_all:
                dataBaseUtility.getPabxDataByBaseID(mContext, baseID);
                header_linear.setVisibility(View.VISIBLE);
                li_filter.setVisibility(View.VISIBLE);
                li_all.setVisibility(View.VISIBLE);
                setPabxList();
                break;
            case R.id.search_li_back:
                finish();
                break;
            case R.id.btn_addnew:
                if (rb_mobile.isChecked()){
                    showAddMobileNumberDialog();
                }else {
//                    toastUtil.appErrorMsg(mContext,"Please  ..........");
                    addPabxNumberDialog();
                }

                break;




        }
    }

    private void showAddMobileNumberDialog() {
        // String downloadFileSize= FileUtils.getFileSize(downloadUrl);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_addmobilenumber, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        Button btnm_cancel = (Button) dialogView.findViewById(R.id.btnm_cancel);
        Button btnm_save = (Button) dialogView.findViewById(R.id.btnm_save);
        final Spinner base_spinner = (Spinner) dialogView.findViewById(R.id.base_spinner);
        final EditText edt_designation=(EditText)dialogView.findViewById(R.id.edt_designation);
        final EditText edt_mobile_no=(EditText)dialogView.findViewById(R.id.edt_mobile_no);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.salutation, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        base_spinner.setAdapter(dataAdapter);
        base_spinner.setSelection(0);
        base_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                base_spinner.clearFocus();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnm_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btnm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_designation.getText().toString().equalsIgnoreCase("")) {
                    edt_designation.requestFocus();
                    toastUtil.appSuccessMsg(mContext, "Designation Required ");
                } else if (edt_mobile_no.getText().toString().equalsIgnoreCase("")) {
                    edt_mobile_no.requestFocus();
                    toastUtil.appSuccessMsg(mContext, "Mobile Number Required ");
                } else {
                    insertData(base_spinner.getSelectedItem().toString(), edt_designation.getText().toString().trim(),
                            edt_mobile_no.getText().toString().trim());

                    alertDialog.dismiss();
                }


            }
        });
        alertDialog.show();
    }

    /************************************
     * Insert Data into new Raw
     * @param baseName
     * @param designationString
     * @param number
     */
    private void insertData(String baseName, String designationString, String number) {

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
        Log.i("Data Are",""+strSQL);
        db.execSQL(strSQL);
        db.setTransactionSuccessful();
        db.endTransaction();
//        db.close();

        toastUtil.appSuccessMsg(mContext, "Data Insert Duccessfully");
        setMobileList();
    }

    private String getBaseID(String baseName) {
        String baseID = "";
        if (baseName.equalsIgnoreCase("Air Headquarter")) {
            baseID = "0";
        } else if (baseName.equalsIgnoreCase("ZHR")) {
            baseID = "2";
        } else if (baseName.equalsIgnoreCase("MTR")) {
            baseID = "3";
        } else if (baseName.equalsIgnoreCase("BSR")) {
            baseID = "4";
        } else if (baseName.equalsIgnoreCase("CXB")) {
            baseID = "6";
        } else if (baseName.equalsIgnoreCase("BBD")) {
            baseID = "5";
        }else if (baseName.equalsIgnoreCase("PKP")) {
            baseID = "7";
        }
        return baseID;
    }
    private void setPabxList() {
        pabxAdapter = new SearchAdapter(this);
        data_list.setAdapter(pabxAdapter);
        data_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);
            }
        });
        // TextFilter
        data_list.setTextFilterEnabled(true);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    pabxAdapter.resetData();
                }
                pabxAdapter.getFilter().filter(s.toString());
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


    private void setMobileList() {
        dataBaseUtility.getAllMobileDataByBaseID(mContext, baseID);
        mobileSearchAdapter = new MobileSearchAdapter(this);
        mobileSearchAdapter.notifyDataSetChanged();
        data_list.setAdapter(mobileSearchAdapter);
        data_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobileListModel query= AllMobileListVector.getAllMobilelist().elementAt(position);
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("header",""+query.getMobileno());
                intent.putExtra("name",""+query.getDesignation());
                startActivity(intent);

            }
        });
        // TextFilter
        data_list.setTextFilterEnabled(true);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    mobileSearchAdapter.resetData();
                }
                mobileSearchAdapter.getFilter().filter(s.toString());
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

    private void showCustomDialog() {
        // String downloadFileSize= FileUtils.getFileSize(downloadUrl);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        Button btn_cancel = (Button) dialogView.findViewById(R.id.btn_cancel);
        Button btn_apply = (Button) dialogView.findViewById(R.id.btn_apply);
        TextView filter_head = (TextView) dialogView.findViewById(R.id.filter_head);
        final Spinner wing_spinner = (Spinner) dialogView.findViewById(R.id.wing_spinner);
        final Spinner sqn_spinner = (Spinner) dialogView.findViewById(R.id.sqn_spinner);

        wing_spinner.setAdapter(detailAdapter);
        wing_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailModel query = AllDetailVector.getAllDetail().elementAt(position);
                dataBaseUtility.getPabxDataByBaseUniqueSqnID(mContext, query.getBase_id(), query.getWing_id());
                sqn_spinner.setAdapter(detailListAdapter);
                sqn_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        swnPosition=position;

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        //text_download.setText(Appconstant.SURA_NAME + " " + getResources().getText(R.string.download_text));
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailListModel query = AllDetailListVector.getAllDetaillist().elementAt(swnPosition);
                setFilterPabxList(query.getBase_id(), query.getWing_id(), query.getSqn_id());
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void setFilterPabxList(String baseID, String wingID, String sqnID) {
        dataBaseUtility.getPabxDataForDetail(mContext, baseID, wingID, sqnID);
        pabxAdapter = new SearchAdapter(this);
        data_list.setAdapter(pabxAdapter);
        data_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PabxListModel query = AllPabxListVector.getAllPabxlist().elementAt(position);
            }
        });
        // TextFilter
        data_list.setTextFilterEnabled(true);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    pabxAdapter.resetData();
                }
                pabxAdapter.getFilter().filter(s.toString());
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


    private void addPabxNumberDialog() {
        // String downloadFileSize= FileUtils.getFileSize(downloadUrl);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_addpabxnumber, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        TextView pabx_btnm_cancel = (TextView) dialogView.findViewById(R.id.pabx_btnm_cancel);
        TextView pabx_btnm_save = (TextView) dialogView.findViewById(R.id.pabx_btnm_save);
        final Spinner pabx_wing_spinner = (Spinner) dialogView.findViewById(R.id.pabx_wing_spinner);
        final Spinner pabx_sqn_spinner = (Spinner) dialogView.findViewById(R.id.pabx_sqn_spinner);
        final EditText edt_pabx_designation=(EditText)dialogView.findViewById(R.id.edt_pabx_designation);
        final EditText edt_pabx_number=(EditText)dialogView.findViewById(R.id.edt_pabx_number);

        pabx_wing_spinner.setAdapter(detailAdapter);
        pabx_wing_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                DetailModel query = AllDetailVector.getAllDetail().elementAt(position);
                dataBaseUtility.getPabxDataByBaseUniqueSqnID(mContext, query.getBase_id(), query.getWing_id());
                pabx_sqn_spinner.setAdapter(detailListAdapter);
                pabx_sqn_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        swnPosition=position;

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        pabx_btnm_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });
        pabx_btnm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailListModel query = AllDetailListVector.getAllDetaillist().elementAt(swnPosition);
                Log.i(TAG,query.getBase_id()+" "+query.getBase_name()+" "+query.getWing_id()+" "+query.getWing_name()+" "+query.getSqn_id()
                        +query.getSqn_name()+" "+getBaseName(baseID)+"  "+baseID+
                " "+edt_pabx_designation.getText().toString()+" "+edt_pabx_number.getText().toString());
//                setFilterPabxList(query.getBase_id(), query.getWing_id(), query.getSqn_id());
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }


    private String getBaseName(String baseID) {
        String baseName = "";
        if (baseID.equalsIgnoreCase("0")) {
            baseName = "Air Headquarter";
        } else if (baseName.equalsIgnoreCase("2")) {
            baseName = "ZHR";
        } else if (baseName.equalsIgnoreCase("3")) {
            baseName = "MTR";
        } else if (baseName.equalsIgnoreCase("4")) {
            baseName = "BSR";
        } else if (baseName.equalsIgnoreCase("6")) {
            baseName = "CXB";
        } else if (baseName.equalsIgnoreCase("5")) {
            baseName = "BBD";
        }else if (baseName.equalsIgnoreCase("7")) {
            baseName = "PKP";
        }
        return baseName;
    }

}
