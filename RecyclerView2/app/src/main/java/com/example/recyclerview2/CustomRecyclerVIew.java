package com.example.recyclerview2;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomRecyclerVIew extends RecyclerView.Adapter<CustomRecyclerVIew.MainViewHolder> {

    Context ctx;
    ArrayList<Movie> movieList;
    Activity activity;
    public  CustomRecyclerVIew(Activity activity,ArrayList<Movie> movieList){
        this.ctx = activity.getApplicationContext();
        this.movieList = movieList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.custom_list,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bindData(movieList.get(position));
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

            ImageView imgPoster;
            TextView txtName,txtGenre;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);

        }
        public  void bindData(final Movie movie){
            imgPoster.setImageResource(ctx.getResources().getIdentifier(movie.poster,"drawable",ctx.getPackageName()));
            txtName.setText(movie.name);
            txtGenre.setText(movie.genre);

        }

    }
}
