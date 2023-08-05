package com.ldcc.example;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
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

    public interface MyRecyclerViewClickListener{
        void onItemClicked(int position);
        void onTitleClicked(int position);
        void onContentClicked(int position);
        void onItemLongClicked(int position);
        void onImageViewClicked(int position);
    }


    private MyRecyclerViewClickListener mListener;

    public void setOnClickListener(MyRecyclerViewClickListener listener) {
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
        holder.title.setText(item.getTitle());
        System.out.println(item.getTitle());
        holder.date.setText(item.getDate());
        holder.image.setImageResource(item.getImage());

        if (mListener != null) {
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onTitleClicked(pos);
                }
            });
            holder.date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onContentClicked(pos);
                }
            });
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onImageViewClicked(pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.onItemLongClicked(holder.getAdapterPosition());
                    return true;
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

            //이미지뷰 원형으로 표시
            image.setBackground(new ShapeDrawable(new OvalShape()));
            image.setClipToOutline(true);
        }
    }

    //리스트 삭제 이벤트
    public void remove(int position){
        try {
            itemData.remove(position);
            notifyDataSetChanged();
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
