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
import com.baf.musafir.bafphonebook.holder.AllDetailListVector;
import com.baf.musafir.bafphonebook.holder.AllPabxListVector;
import com.baf.musafir.bafphonebook.model.DetailListModel;
import com.baf.musafir.bafphonebook.model.PabxListModel;

import java.io.File;
import java.util.List;

public class DetailListAdapter extends ArrayAdapter<DetailListModel> implements SpinnerAdapter {
    Context context;
    private File sdCard = Environment.getExternalStorageDirectory();

    private Filter planetFilter;
    private List<DetailListModel> detailListModels;

    public DetailListAdapter(Context context, int textViewResourceId) {
        super(context, R.layout.row_list_detail, AllDetailListVector.getAllDetaillist());
        this.context = context;
        this.detailListModels = AllDetailListVector.getAllDetaillist();

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

        private TextView txt_section_list;




    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View v = convertView;

        if (v == null) {
            final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_list_detail, parent,false);
            // convertView = _inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.txt_section_list = (TextView) v.findViewById(R.id.txt_section_list);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (position < AllDetailListVector.getAllDetaillist().size()) {
            DetailListModel query = detailListModels.get(position);
            holder.txt_section_list.setText(query.getSqn_name());





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