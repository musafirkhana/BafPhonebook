package com.baf.musafir.bafphonebook.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.holder.AllAbbrListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.AbbrlListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends ArrayAdapter<PabxListModel> implements SpinnerAdapter {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();

    private Filter planetFilter;
    private List<PabxListModel> origPlanetList;

    public DetailAdapter(Context context,int textViewResourceId) {
        super(context, R.layout.row_detail, AllPabxListVector.getAllPabxlist());
        this.context = context;
        this.origPlanetList = AllPabxListVector.getAllPabxlist();

    }

    /*public int getCount() {
        return origPlanetList.size();
    }

    public PabxListModel getItem(int position) {
        return origPlanetList.get(position);
    }

    public long getItemId(int position) {
        return origPlanetList.get(position).hashCode();
    }*/

    static class ViewHolder {

        private TextView txt_section;
        private TextView txt_id;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_detail, parent,false);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_section = (TextView) v.findViewById(R.id.txt_section);
            holder.txt_id = (TextView) v.findViewById(R.id.txt_id);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllPabxListVector.getAllPabxlist().size()) {
            PabxListModel query = origPlanetList.get(position);
            holder.txt_section.setText(query.getWing_name());
            holder.txt_id.setText(query.getBase_id());





        }

        return v;
    }
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getView(position, convertView, parent);
    }


    /*public void resetData() {
        origPlanetList = origPlanetList;
    }*/
    /*
	 * We create our filter
	 */


}