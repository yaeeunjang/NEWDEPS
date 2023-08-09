package com.ldcc.example;

import android.graphics.Color;
import android.icu.text.SymbolTable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class RouteRecycleViewAdapter extends RecyclerView.Adapter<RouteRecycleViewAdapter.ViewHolder> {

    private ArrayList<RecycleViewItem> itemData;


    public RouteRecycleViewAdapter(ArrayList<RecycleViewItem> itemData) {
        this.itemData = itemData;
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }


    private OnItemClickListener mListener;

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_main_recycleview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        RecycleViewItem item = itemData.get(position);
        holder.image.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());
        if(itemData.get(position).getSelectedTF() == true){
            holder.itemView.setBackgroundColor(Color.GRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }

        if (mListener != null) {
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            date = itemView.findViewById(R.id.textviewDate);
            image = itemView.findViewById(R.id.imageViewRoute);


            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    int pos = getAdapterPosition();
                    for(int i=0; i< itemData.size(); i ++) {
                        itemData.get(i).setSelected(false);
                    }
                    itemData.get(pos).setSelected(true);

                    notifyDataSetChanged();
                }
            });
        }
    }
}


