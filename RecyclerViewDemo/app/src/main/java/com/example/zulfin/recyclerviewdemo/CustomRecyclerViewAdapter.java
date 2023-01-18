package com.example.zulfin.recyclerviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.MainViewHolder> {

    Context context;
    ArrayList<Movie> movieList;
    Activity activity;

    public CustomRecyclerViewAdapter(Activity activity, ArrayList<Movie> movieList) {
        this.context = activity.getApplicationContext();
        this.activity = activity;
        this.movieList = movieList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list,viewGroup,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder mainViewHolder, int i) {
        mainViewHolder.bindData(movieList.get(i));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPoster;
        LinearLayout linearLayout;
        TextView txtName, txtGenre;

        public MainViewHolder(View itemView) {
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);

        }

        public void bindData(final Movie movie){
            imgPoster.setImageResource(context.getResources().getIdentifier(movie.poster, "drawable", context.getPackageName()));
            txtName.setText(movie.name);
            txtGenre.setText(movie.genre);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, movie.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, DetailsActivity.class);
                    intent.putExtra("movie", movie);
                    activity.startActivity(intent);
                }
            });

        }
    }
}
