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

import com.baf.musafir.bafphonebook.DetailActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.holder.AllNwdListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.NwdListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NwdAdapter extends ArrayAdapter<NwdListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<NwdListModel> origPlanetList;
    private List<NwdListModel> planetList;

    public NwdAdapter(Context context) {
        super(context, R.layout.row_nwd, AllNwdListVector.getAllNwdlist());
        this.context = context;
        this.context = context;
        this.planetList = AllNwdListVector.getAllNwdlist();
        this.origPlanetList = AllNwdListVector.getAllNwdlist();

    }

    public int getCount() {
        return planetList.size();
    }

    public NwdListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView txt_areaname;
        private TextView row_txtareacode;



    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_nwd, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_areaname = (TextView) v.findViewById(R.id.txt_areaname);
            holder.row_txtareacode = (TextView) v.findViewById(R.id.row_txtareacode);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllNwdListVector.getAllNwdlist().size()) {
            NwdListModel query = planetList.get(position);
            holder.txt_areaname.setText(query.getArea());
            holder.row_txtareacode.setText(query.getCode());





        }

        return v;
    }

    public void resetData() {
        planetList = origPlanetList;
    }
    /*
	 * We create our filter
	 */

    @Override
    public Filter getFilter() {
        if (planetFilter == null)
            planetFilter = new PlanetFilter();

        return planetFilter;
    }

    private class PlanetFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = origPlanetList;
                results.count = origPlanetList.size();
            } else {
                // We perform filtering operation
                List<NwdListModel> nPlanetList = new ArrayList<NwdListModel>();
                for (NwdListModel p : planetList) {

                    if (p.getArea().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
                        nPlanetList.add(p);
                    }

                }

                results.values = nPlanetList;
                results.count = nPlanetList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                planetList = (List<NwdListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}