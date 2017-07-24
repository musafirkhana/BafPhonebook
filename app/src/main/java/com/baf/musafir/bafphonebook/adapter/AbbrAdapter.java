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
import com.baf.musafir.bafphonebook.holder.AllAbbrListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.main.DetailActivity;
import com.baf.musafir.bafphonebook.model.AbbrlListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AbbrAdapter extends ArrayAdapter<AbbrlListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();

    private Filter planetFilter;
    private List<AbbrlListModel> origPlanetList;
    private List<AbbrlListModel> planetList;

    public AbbrAdapter(Context context) {
        super(context, R.layout.row_abbr, AllAbbrListVector.getAllAbbrlist());
        this.context = context;
        this.context = context;
        this.planetList = AllAbbrListVector.getAllAbbrlist();
        this.origPlanetList = AllAbbrListVector.getAllAbbrlist();

    }

    public int getCount() {
        return planetList.size();
    }

    public AbbrlListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView txt_name;
        private TextView txtx_abbr;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_abbr, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_name = (TextView) v.findViewById(R.id.txt_name);
            holder.txtx_abbr = (TextView) v.findViewById(R.id.txtx_abbr);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllAbbrListVector.getAllAbbrlist().size()) {
            AbbrlListModel query = planetList.get(position);
            holder.txt_name.setText(query.getAbbr());
            holder.txtx_abbr.setText(query.getAbbreviate());





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
                List<AbbrlListModel> nPlanetList = new ArrayList<AbbrlListModel>();
                for (AbbrlListModel p : planetList) {

                    if (p.getAbbr().toUpperCase()
                            .startsWith(constraint.toString().toUpperCase())||
                            p.getAbbreviate().toUpperCase()
                                    .contains(constraint.toString().toUpperCase())) {
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
                planetList = (List<AbbrlListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}