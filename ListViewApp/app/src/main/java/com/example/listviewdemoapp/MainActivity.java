package com.example.listviewdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    customListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        movieList.add(new Movie(1, "Bolt", "poster1", "Animation"));
        movieList.add(new Movie(2, "Angry Birds", "poster2", "Comedy"));
        movieList.add(new Movie(3, "Fast Five", "poster3", "Action"));
        movieList.add(new Movie(4, "Lion King", "poster4", "Animation"));
        movieList.add(new Movie(5, "Avengers", "poster5", "Science Fiction"));
        movieList.add(new Movie(6, "Dr Strange", "poster6", "Science Fiction"));
        movieList.add(new Movie(7, "Jumanji", "poster7", "Adventure"));

        adapter = new customListAdapter(MainActivity.this,movieList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this,DetailedActivity.class);
                i.putExtra("movie",movieList.get(position));
                startActivity(i);
            }
        });
    }




}