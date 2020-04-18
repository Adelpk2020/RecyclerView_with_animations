package com.example.fzaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {

    Context context;
    List<DataModel> mData;
    List<DataModel> mDataFiltered;
    boolean isDark=false;

    public DataAdapter(Context context, List<DataModel> mData, boolean isDark) {
        this.context = context;
        this.mData = mData;
        this.isDark = isDark;
        this.mDataFiltered=mData;
    }

    public DataAdapter(Context context, List<DataModel> mData) {
        this.context = context;
        this.mData = mData;
        this.mDataFiltered=mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout= LayoutInflater.from(context).inflate(R.layout.item_data,parent,false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //apply animation to view
        //firstly on images
        holder.img.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
        //apply animation on all card
        //firstly create a reference to it in the viewholder class
        holder.container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

        holder.tv_title.setText(mDataFiltered.get(position).getTitle());
        holder.tv_content.setText(mDataFiltered.get(position).getContent());
        holder.tv_date.setText(mDataFiltered.get(position).getDate());
        holder.img.setImageResource(mDataFiltered.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String Key = charSequence.toString();
                if (Key.isEmpty()) {

                    mDataFiltered = mData ;

                }
                else {
                    List<DataModel> lstFiltered = new ArrayList<>();
                    for (DataModel row : mData) {

                        if (row.getTitle().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }

                    mDataFiltered = lstFiltered;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= mDataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mDataFiltered = (List<DataModel>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title,tv_content,tv_date;
        ImageView img;
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container=itemView.findViewById(R.id.container);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_content=itemView.findViewById(R.id.tv_description);
            tv_title=itemView.findViewById(R.id.tv_title);
            img=itemView.findViewById(R.id.img);

            if(isDark){
                setDarkTheme();
            }
        }

        private void setDarkTheme() {

            container.setBackgroundResource(R.drawable.card_bg_dark);

        }
    }
}
