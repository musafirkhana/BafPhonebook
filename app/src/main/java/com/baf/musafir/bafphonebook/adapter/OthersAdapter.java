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

        private TextView other_designation;
        private TextView others_name;
        private TextView others_id;
        private TextView others_office;
        private TextView others_res;




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

            holder.other_designation = (TextView) v.findViewById(R.id.other_designation);
            holder.others_name = (TextView) v.findViewById(R.id.others_name);
            holder.others_id = (TextView) v.findViewById(R.id.others_id);
            holder.others_office = (TextView) v.findViewById(R.id.others_office);
            holder.others_res = (TextView) v.findViewById(R.id.others_res);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllOthersListVector.getAllOtherslist().size()) {
            OthersListModel query = planetList.get(position);
            holder.other_designation.setText(query.getDesignation());
            holder.others_name.setText(query.getOrg_name());
            holder.others_id.setText(query.getOrg_id());
            holder.others_office.setText(query.getOffice_ext());
            holder.others_res.setText(query.getRes_ext());

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

                    if (p.getDesignation().toUpperCase().contains(constraint.toString().toUpperCase())||
                            p.getOffice_ext().toUpperCase().contains(constraint.toString().toUpperCase())) {
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