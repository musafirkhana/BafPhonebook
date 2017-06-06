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
import com.baf.musafir.bafphonebook.holder.AllCadetCollegeListVector;
import com.baf.musafir.bafphonebook.holder.AllOthersListVector;
import com.baf.musafir.bafphonebook.model.CadetCollegeListModel;
import com.baf.musafir.bafphonebook.model.OthersListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CadetCollegeAdapter extends ArrayAdapter<CadetCollegeListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<CadetCollegeListModel> origPlanetList;
    private List<CadetCollegeListModel> planetList;

    public CadetCollegeAdapter(Context context) {
        super(context, R.layout.row_cc, AllCadetCollegeListVector.getAllCadetCollegelist());
        this.context = context;
        this.context = context;
        this.planetList = AllCadetCollegeListVector.getAllCadetCollegelist();
        this.origPlanetList = AllCadetCollegeListVector.getAllCadetCollegelist();

    }

    public int getCount() {
        return planetList.size();
    }

    public CadetCollegeListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView cc_mobile_no;
        private TextView cc_appoinment;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_cc, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.cc_mobile_no = (TextView) v.findViewById(R.id.cc_mobile_no);
            holder.cc_appoinment = (TextView) v.findViewById(R.id.cc_appoinment);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllCadetCollegeListVector.getAllCadetCollegelist().size()) {
            CadetCollegeListModel query = planetList.get(position);
            holder.cc_mobile_no.setText(query.getMobile_no());
            holder.cc_appoinment.setText(query.getDesignation()+","+query.getCollage_name());

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
                List<CadetCollegeListModel> nPlanetList = new ArrayList<CadetCollegeListModel>();
                for (CadetCollegeListModel p : planetList) {

                    if (p.getCollage_name().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<CadetCollegeListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}