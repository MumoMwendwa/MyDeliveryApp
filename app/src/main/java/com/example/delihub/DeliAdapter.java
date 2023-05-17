package com.example.delihub;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliAdapter extends RecyclerView.Adapter<DeliAdapter.Deliholder>  {
    List<Deli_Item> data;
    int selectedItem = 0;

    public DeliAdapter(List<Deli_Item> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public Deliholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.deli_holder, parent, false);
        return new Deliholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Deliholder holder, int position) {
        holder.price.setText(String.format("Ksh%d", data.get(position).getPrice()));
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getName());
        holder.ratingBar.setRating(data.get(position).getRating());

        if (selectedItem == position) {
            holder.cardView.animate().scaleX(1.1f);
            holder.cardView.animate().scaleY(1.1f);
            holder.llBackground.setBackgroundResource(R.color.white);
        } else {
            holder.cardView.animate().scaleX(1f);
            holder.cardView.animate().scaleY(1f);
            holder.llBackground.setBackgroundResource(R.drawable.splash);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Deliholder extends RecyclerView.ViewHolder {
        RatingBar ratingBar;
        ImageView image;
        TextView title;
        TextView price;
        LinearLayout llBackground;
        CardView cardView;
        TextView ttl;

        public Deliholder(View holder) {
            super(holder);
            ratingBar = holder.findViewById(R.id.rating);
            image = holder.findViewById(R.id.deli_img);
            title = holder.findViewById(R.id.delivery_title);
            price = holder.findViewById(R.id.txt_price);
            cardView = holder.findViewById(R.id.deli_background);
            llBackground = holder.findViewById(R.id.ll_background);
            ttl = holder.findViewById(R.id.Orderbtn);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedItem = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
            ttl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.getContext(),MapsActivity.class);
                    holder.getContext().startActivity(intent);
                }
            });
        }
}}
