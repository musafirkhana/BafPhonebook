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
import com.baf.musafir.bafphonebook.holder.AllEmailListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.main.DetailActivity;
import com.baf.musafir.bafphonebook.model.EmailListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EmailAdapter extends ArrayAdapter<EmailListModel> {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();
    public String response;
    public boolean asyncCheck = false;
    public String ContentCode;
    public String mobileNo;
    File pathName = null;

    private Filter planetFilter;
    private List<EmailListModel> origPlanetList;
    private List<EmailListModel> planetList;

    public EmailAdapter(Context context) {
        super(context, R.layout.row_email, AllEmailListVector.getAllEmaillist());
        this.context = context;
        this.context = context;
        this.planetList = AllEmailListVector.getAllEmaillist();
        this.origPlanetList = AllEmailListVector.getAllEmaillist();

    }

    public int getCount() {
        return planetList.size();
    }

    public EmailListModel getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    static class ViewHolder {

        private TextView row_txt_designation_email;
        private TextView txt_basename_email;
        private TextView txt_sqnname_email;
        private TextView row_txt_email;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_email, null);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.row_txt_designation_email = (TextView) v.findViewById(R.id.row_txt_designation_email);
            holder.txt_basename_email = (TextView) v.findViewById(R.id.txt_basename_email);
            holder.txt_sqnname_email = (TextView) v.findViewById(R.id.txt_sqnname_email);
            holder.row_txt_email = (TextView) v.findViewById(R.id.row_txt_email);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllEmailListVector.getAllEmaillist().size()) {
            EmailListModel query = planetList.get(position);
            holder.row_txt_designation_email.setText(query.getDesignation());
            holder.txt_basename_email.setText(query.getUnit_base());
            holder.txt_sqnname_email.setText(query.getUnit_id());
            holder.row_txt_email.setText(query.getEmail_add());

          /*  if(query.getMobile_no().toString().length()<3){
                holder.call_linear.setVisibility(View.GONE);
            }else {
                holder.call_linear.setVisibility(View.VISIBLE);
                holder.txt_appoinment.setText(query.getDesignation());
                holder.pabx_mobile_no.setText(query.getMobile_no().toString());
                holder.call_linear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PabxListModel query1 = planetList.get(position);
                       *//* Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+""+query1.getMobile_no()));
                        context.startActivity(callIntent);*//*
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("header",""+query1.getMobile_no());
                        intent.putExtra("name",""+query1.getDesignation());
                        context.startActivity(intent);
                    }
                });
            }*/


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
                List<EmailListModel> nPlanetList = new ArrayList<EmailListModel>();
                for (EmailListModel p : planetList) {

                    if (p.getDesignation().toUpperCase().startsWith(constraint.toString().toUpperCase())||
                            p.getEmail_add().toUpperCase().startsWith(constraint.toString().toUpperCase())) {
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
                planetList = (List<EmailListModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}