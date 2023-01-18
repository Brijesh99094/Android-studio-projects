package com.example.listviewdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class customListAdapter extends ArrayAdapter<Movie> {

        Context context;
        ArrayList<Movie> movieList;

        public customListAdapter(Context context ,ArrayList<Movie> movieList){
            super(context,R.layout.activity_custom_list_adapter,movieList);
            this.context = context;
            this.movieList = movieList;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_custom_list_adapter,null,false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textName = (TextView) view.findViewById(R.id.textName);
            TextView textGenere = (TextView) view.findViewById(R.id.textGenre);

            textName.setText(movieList.get(position).name);
            textGenere.setText(movieList.get(position).genre);
            imageView.setImageResource(context.getResources().getIdentifier(movieList.get(position).poster,"drawable",context.getPackageName()));

            return  view;
        }
}