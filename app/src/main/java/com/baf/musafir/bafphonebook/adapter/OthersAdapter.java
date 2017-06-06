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
import com.baf.musafir.bafphonebook.holder.AllOthersListVector;
import com.baf.musafir.bafphonebook.model.OthersListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OthersAdapter extends ArrayAdapter<OthersListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();

    private Filter otherFilter;
    private List<OthersListModel> origOtherList;
    private List<OthersListModel> planetList;

    public OthersAdapter(Context context) {
        super(context, R.layout.row_others, AllOthersListVector.getAllOtherslist());
        this.context = context;
        this.context = context;
        this.planetList = AllOthersListVector.getAllOtherslist();
        this.origOtherList = AllOthersListVector.getAllOtherslist();

    }

    public int getCount() {
        return planetList.size();
    }

    public OthersListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView row_others_mobile_no;
        private TextView row_txt_appoinment;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_others, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.row_others_mobile_no = (TextView) v.findViewById(R.id.row_others_mobile_no);
            holder.row_txt_appoinment = (TextView) v.findViewById(R.id.row_txt_appoinment);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllOthersListVector.getAllOtherslist().size()) {
            OthersListModel query = planetList.get(position);
            holder.row_others_mobile_no.setText(query.getNumber());
            holder.row_txt_appoinment.setText(query.getDesignation()+","+query.getArea_name());

        }

        return v;
    }

    public void resetData() {
        planetList = origOtherList;
    }
    /*
	 * We create our filter
	 */

    @Override
    public Filter getFilter() {
        if (otherFilter == null)
            otherFilter = new OtherFilter();

        return otherFilter;
    }

    private class OtherFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = origOtherList;
                results.count = origOtherList.size();
            } else {
                // We perform filtering operation
                List<OthersListModel> nPlanetList = new ArrayList<OthersListModel>();
                for (OthersListModel p : planetList) {

                    if (p.getDesignation().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<OthersListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}