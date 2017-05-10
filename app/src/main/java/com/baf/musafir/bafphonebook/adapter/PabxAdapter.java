package com.baf.musafir.bafphonebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baf.musafir.bafphonebook.DetailActivity;
import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.holder.AllContactListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.ContactListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PabxAdapter extends ArrayAdapter<PabxListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<PabxListModel> origPlanetList;
    private List<PabxListModel> planetList;

    public PabxAdapter(Context context) {
        super(context, R.layout.row_contact, AllPabxListVector.getAllPabxlist());
        this.context = context;
        this.context = context;
        this.planetList = AllPabxListVector.getAllPabxlist();
        this.origPlanetList = AllPabxListVector.getAllPabxlist();

    }

    public int getCount() {
        return planetList.size();
    }

    public PabxListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView txt_designation;
        private TextView txt_office_ext;
        private TextView txt_office_auto;
        private TextView txt_res_ext;
        private TextView txt_res_auto;
        private RelativeLayout call_linear;
        private TextView pabx_mobile_no;
        private TextView txt_appoinment;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_pabx, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_designation = (TextView) v.findViewById(R.id.txt_designation);
            holder.txt_office_ext = (TextView) v.findViewById(R.id.txt_office_ext);
            holder.txt_office_auto = (TextView) v.findViewById(R.id.txt_office_auto);
            holder.txt_res_ext = (TextView) v.findViewById(R.id.txt_res_ext);
            holder.txt_res_auto = (TextView) v.findViewById(R.id.txt_res_auto);
            holder.pabx_mobile_no = (TextView) v.findViewById(R.id.pabx_mobile_no);
            holder.txt_appoinment = (TextView) v.findViewById(R.id.txt_appoinment);
            holder.call_linear=(RelativeLayout)v.findViewById(R.id.call_linear);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllPabxListVector.getAllPabxlist().size()) {
            PabxListModel query = planetList.get(position);
            holder.txt_designation.setText(query.getDesignation());
            holder.txt_office_ext.setText(query.getOffice_ext());
            holder.txt_office_auto.setText(query.getOffice_auto());
            holder.txt_res_ext.setText(query.getResident_ext());
            holder.txt_res_auto.setText(query.getResident_auto());

            if(query.getMobile_no().toString().length()<3){
                holder.call_linear.setVisibility(View.GONE);
            }else {
                holder.call_linear.setVisibility(View.VISIBLE);
                holder.txt_appoinment.setText(query.getDesignation());
                holder.pabx_mobile_no.setText(query.getMobile_no().toString());
                holder.call_linear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PabxListModel query1 = planetList.get(position);
                       /* Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+""+query1.getMobile_no()));
                        context.startActivity(callIntent);*/
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("header",""+query1.getMobile_no());
                        intent.putExtra("name",""+query1.getDesignation());
                        context.startActivity(intent);
                    }
                });
            }


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
                List<PabxListModel> nPlanetList = new ArrayList<PabxListModel>();
                for (PabxListModel p : planetList) {

                    if (p.getDesignation().toUpperCase().startsWith(constraint.toString().toUpperCase())||
                            p.getSqn_name().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<PabxListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}