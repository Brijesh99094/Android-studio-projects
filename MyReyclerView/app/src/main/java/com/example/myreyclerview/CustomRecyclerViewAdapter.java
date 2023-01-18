package com.example.myreyclerview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.MainViewHolder> {

    Context context;
    ArrayList<Movie> movieList;
    Activity activity;

    public CustomRecyclerViewAdapter(Activity activity,ArrayList<Movie> movieList) {
        this.context = activity.getApplicationContext();
        this.activity = activity;
        this.movieList = movieList;
    }
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false);
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

    public  class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        LinearLayout linearLayout;
        TextView txtName,txtGenre;

        public  MainViewHolder(View itemView){
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);

        }

        public void bindData(final  Movie movie){
            imgPoster.setImageResource(context.getResources().getIdentifier(movie.poster,"drawable",context.getPackageName()));
            txtName.setText(movie.name);
            txtGenre.setText(movie.genre);
        }



    }
}

