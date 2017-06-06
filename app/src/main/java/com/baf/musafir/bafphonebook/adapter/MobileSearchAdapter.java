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
import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.holder.AllMobileListVector;
import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.MobileListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MobileSearchAdapter extends ArrayAdapter<MobileListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<MobileListModel> origPlanetList;
    private List<MobileListModel> planetList;

    public MobileSearchAdapter(Context context) {
        super(context, R.layout.row_mobile, AllMobileListVector.getAllMobilelist());
        this.context = context;
        this.context = context;
        this.planetList = AllMobileListVector.getAllMobilelist();
        this.origPlanetList = AllMobileListVector.getAllMobilelist();

    }

    public int getCount() {
        return planetList.size();
    }

    public MobileListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView designation;
        private TextView mobile_no;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_mobile, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.designation = (TextView) v.findViewById(R.id.m_designation);
            holder.mobile_no = (TextView) v.findViewById(R.id.m_mobile_no);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllMobileListVector.getAllMobilelist().size()) {
            MobileListModel query = planetList.get(position);
            holder.designation.setText(query.getDesignation()+","+query.getBase_name());
            holder.mobile_no.setText(query.getMobileno());


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
                List<MobileListModel> nPlanetList = new ArrayList<MobileListModel>();
                for (MobileListModel p : planetList) {

                    if (p.getDesignation().toUpperCase().startsWith(constraint.toString().toUpperCase())||
                            p.getBase_name().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<MobileListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}