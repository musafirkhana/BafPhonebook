package com.baf.musafir.bafphonebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.holder.AllRanlListVector;
import com.baf.musafir.bafphonebook.main.DetailActivity;
import com.baf.musafir.bafphonebook.model.PabxListModel;
import com.baf.musafir.bafphonebook.model.RankListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RankAdapter extends ArrayAdapter<RankListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<RankListModel> origPlanetList;
    private List<RankListModel> planetList;

    public RankAdapter(Context context) {
        super(context, R.layout.row_rank_detail, AllRanlListVector.getAllRanklist());
        this.context = context;
        this.context = context;
        this.planetList = AllRanlListVector.getAllRanklist();
        this.origPlanetList = AllRanlListVector.getAllRanklist();

    }

    public int getCount() {
        return planetList.size();
    }

    public RankListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView txt_army;
        private TextView txt_navvy;
        private TextView txt_airforce;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_rank_detail, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_army = (TextView) v.findViewById(R.id.txt_army);
            holder.txt_navvy = (TextView) v.findViewById(R.id.txt_navvy);
            holder.txt_airforce = (TextView) v.findViewById(R.id.txt_airforce);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllRanlListVector.getAllRanklist().size()) {
            RankListModel query = planetList.get(position);
            holder.txt_army.setText(query.getArmy());
            holder.txt_navvy.setText(query.getNavvy());
            holder.txt_airforce.setText(query.getAirforce());



        }

        return v;
    }

    public void resetData() {
        planetList = origPlanetList;
    }
    /*
	 * We create our filter
	 */




}