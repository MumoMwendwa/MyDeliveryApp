package com.example.delihub;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.location.GnssAntennaInfo;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class DelicatAdapter extends RecyclerView.Adapter<DelicatAdapter.DeliHolder> {


    List<DeliCategories> data;
    Context context;
    int selectedItem = 0;

    OnCategoryClick onCategoryClick;

    public interface OnCategoryClick{
        void onClick(int pos);
    }
    public DelicatAdapter(List<DeliCategories> data, Context context, OnCategoryClick onCategoryClick){
        this.data = data;
        this.context = context;
        this.onCategoryClick = onCategoryClick;

    }


    @NonNull
    @Override
    public DeliHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.categories_holder, parent,false);
        return new DeliHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliHolder holder, int position) {
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getName());
        if (position == selectedItem){
            //Make card selected
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(R.color.black));
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(R.color.black));
            holder.cardView.setStrokeWidth(0);
            holder.title.setTextColor(context.getColor(R.color.black));
            holder.image.setColorFilter(R.color.black);
        }else{
            // Make card inactive
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(android.R.color.darker_gray));
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(android.R.color.darker_gray));
            holder.title.setTextColor(context.getColor(R.color.black));

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DeliHolder extends RecyclerView.ViewHolder {
        TextView title; 
        ImageView image;
        MaterialCardView cardView;
        public DeliHolder(View holder) {
            super(holder);
            title = holder.findViewById(R.id.txtglovo);
            image = holder.findViewById(R.id.Glovo);
            cardView = holder.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedItem = getAdapterPosition();
                    //reset items so that color changes when we click on  card
                    
                    if (onCategoryClick != null) {
                        onCategoryClick.onClick(getAdapterPosition());
                    }
                    notifyDataSetChanged();


                }

        });
    }
    }

}






