package com.techgigandroidhackathon.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techgigandroidhackathon.R;
import com.techgigandroidhackathon.VOs.CountryVO;

import java.util.ArrayList;

/**
 * Created by Amol G on 23-11-2017.
 */

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.MyViewHolder> {

    private ArrayList<CountryVO> countryListVOs = new ArrayList<>();
    private Context context;

    public CountryListAdapter(Context context, ArrayList<CountryVO> countryListVOs) {
        this.context = context;
        this.countryListVOs = countryListVOs;
    }

    @Override
    public CountryListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CountryListAdapter.MyViewHolder holder, int position) {
        CountryVO countryVO = countryListVOs.get(position);
        holder.getCountryName().setText(countryVO.getName());
    }

    @Override
    public int getItemCount() {
        return countryListVOs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;

        public MyViewHolder(View itemView) {
            super(itemView);
            initializeUiElements(itemView);
        }

        private void initializeUiElements(View view) {
            countryName = (TextView) view.findViewById(R.id.countryNameTxt);
        }

        public TextView getCountryName() {
            return countryName;
        }
    }
}
