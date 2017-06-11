package com.jolly.androiddagger.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jolly.androiddagger.Model.Model;
import com.jolly.androiddagger.R;

import java.util.ArrayList;

/**
 * Created by Jollyboy on 10/06/17.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
private ArrayList<Model> listItems =new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleText.setText(listItems.get(position).getTitle());
        holder.idText.setText(listItems.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void update(ArrayList<Model> body) {
        listItems.addAll(body);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idText,titleText;
        public ViewHolder(View itemView) {
            super(itemView);
            idText = (TextView) itemView.findViewById(R.id.idText);
            titleText = (TextView) itemView.findViewById(R.id.titleText);
        }
    }
}
