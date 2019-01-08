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
import com.baf.musafir.bafphonebook.holder.AllEmailListVector;
import com.baf.musafir.bafphonebook.holder.AllNumberPlanListVector;
import com.baf.musafir.bafphonebook.model.EmailListModel;
import com.baf.musafir.bafphonebook.model.NumberPlanListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NumberPlanAdapter extends ArrayAdapter<NumberPlanListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<NumberPlanListModel> origPlanetList;
    private List<NumberPlanListModel> planetList;

    public NumberPlanAdapter(Context context) {
        super(context, R.layout.row_number_planl, AllNumberPlanListVector.getAllNumberPlanlist());
        this.context = context;
        this.context = context;
        this.planetList = AllNumberPlanListVector.getAllNumberPlanlist();
        this.origPlanetList = AllNumberPlanListVector.getAllNumberPlanlist();

    }

    public int getCount() {
        return planetList.size();
    }

    public NumberPlanListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView plan_name;
        private TextView service_name;
        private TextView service_id;
        private TextView ext_code;
        private TextView mobile_code;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_number_planl, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.plan_name = (TextView) v.findViewById(R.id.plan_name);
            holder.service_name = (TextView) v.findViewById(R.id.service_name);
            holder.service_id = (TextView) v.findViewById(R.id.service_id);
            holder.ext_code = (TextView) v.findViewById(R.id.ext_code);
            holder.mobile_code = (TextView) v.findViewById(R.id.mobile_code);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllNumberPlanListVector.getAllNumberPlanlist().size()) {
            NumberPlanListModel query = planetList.get(position);
            holder.plan_name.setText(query.getName());
            holder.service_name.setText(query.getService_name());
            holder.service_id.setText(query.getService_id());
            holder.ext_code.setText(query.getExt_code());
            holder.mobile_code.setText(query.getMobile_code());




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
                List<NumberPlanListModel> nPlanetList = new ArrayList<NumberPlanListModel>();
                for (NumberPlanListModel p : planetList) {

                    if (p.getName().toUpperCase().startsWith(constraint.toString().toUpperCase())||
                            p.getExt_code().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<NumberPlanListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}