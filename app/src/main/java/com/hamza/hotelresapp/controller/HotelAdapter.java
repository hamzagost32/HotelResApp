package com.hamza.hotelresapp.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hamza.hotelresapp.R;
import com.hamza.hotelresapp.model.Hotel;
import com.hamza.hotelresapp.model.User;
import com.hamza.hotelresapp.userView.HotelInfoActivity;
import com.hamza.hotelresapp.userView.HotelSearch;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>  {

    private LayoutInflater inflater;
    private ArrayList<Hotel> hotels;
    private Context ctx;
    private User user;

    public HotelAdapter(Context context,ArrayList<Hotel> arrayList, User user){
        this.ctx = context;
        this.inflater = LayoutInflater.from(ctx);
        this.hotels = arrayList;
        this.user = user;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.hotel_list_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        holder.hname.setText(hotels.get(i).getName());
        holder.hrate.setText(hotels.get(i).getRate());
        holder.hadress.setText(hotels.get(i).getAddress());
        holder.hlocation.setText(hotels.get(i).getLocation());

        Glide.with(ctx).load(hotels.get(i).getPhotoUrl()).into(holder.photoUrl);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(), HotelInfoActivity.class);

                int id = hotels.get(holder.getAdapterPosition()).getId();

                user.setHotelId(id);

                intent.putExtra("hotel_id",id);
                intent.putExtra("user", user);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView hname,hrate,hadress,hlocation;
        public CardView cardView;
        ImageView photoUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            hname = itemView.findViewById(R.id.hotel_name);
            hrate = itemView.findViewById(R.id.hote_rate);
            hadress = itemView.findViewById(R.id.hotel_adress);
            hlocation = itemView.findViewById(R.id.hotel_location);
            photoUrl = itemView.findViewById(R.id.hotel_photo);
        }
    }

}
