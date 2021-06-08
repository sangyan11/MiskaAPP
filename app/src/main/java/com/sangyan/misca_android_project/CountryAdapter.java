package com.sangyan.misca_android_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    LayoutInflater context;
    List<Country> data;

    public CountryAdapter (Context context,List<Country> data){
        this.context=LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View Item = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list, parent, false);
        return new ViewHolder(Item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(data.get(position).getName());
        holder.capital.setText(data.get(position).getCapital());
//        Picasso.get().load(data.get(position).getImage_url()).into(holder.image);




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private  TextView capital;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.country_name);
            capital = itemView.findViewById(R.id.capital);
           // image = itemView.findViewById(R.id.flag);



        }

    }
}
