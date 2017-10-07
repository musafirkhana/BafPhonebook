package com.baf.musafir.bafphonebook.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.holder.AllRanlListVector;
import com.baf.musafir.bafphonebook.holder.AllUnitListVector;
import com.baf.musafir.bafphonebook.model.RankListModel;
import com.baf.musafir.bafphonebook.model.UnitListModel;

import java.io.File;
import java.util.List;

public class UnitAdapter extends ArrayAdapter<UnitListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<UnitListModel> origPlanetList;
    private List<UnitListModel> planetList;

    public UnitAdapter(Context context) {
        super(context, R.layout.row_unit_detail, AllUnitListVector.getAllUnitlist());
        this.context = context;
        this.context = context;
        this.planetList = AllUnitListVector.getAllUnitlist();
        this.origPlanetList = AllUnitListVector.getAllUnitlist();

    }

    public int getCount() {
        return planetList.size();
    }

    public UnitListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView txt_unitname;
        private TextView txt_typeac;
        private TextView txt_base;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_unit_detail, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_unitname = (TextView) v.findViewById(R.id.txt_unitname);
            holder.txt_typeac = (TextView) v.findViewById(R.id.txt_typeac);
            holder.txt_base = (TextView) v.findViewById(R.id.txt_base);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllUnitListVector.getAllUnitlist().size()) {
            UnitListModel query = planetList.get(position);
            holder.txt_unitname.setText(query.getUnit());
            holder.txt_typeac.setText(query.getTypes());
            holder.txt_base.setText(query.getBase_name());



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