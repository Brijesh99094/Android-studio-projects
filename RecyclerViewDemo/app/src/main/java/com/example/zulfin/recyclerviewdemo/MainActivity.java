package com.example.zulfin.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    CustomRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        movieList.add(new Movie(1, "Bolt", "poster1", "Animation"));
        movieList.add(new Movie(2, "Angry Birds", "poster2", "Comedy"));
        movieList.add(new Movie(3, "Fast Five", "poster3", "Action"));
        movieList.add(new Movie(4, "Lion King", "poster4", "Animation"));
        movieList.add(new Movie(5, "Avengers", "poster5", "Science Fiction"));

        adapter = new CustomRecyclerViewAdapter(MainActivity.this, movieList);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
//        recyclerView.setLayoutManager(gridLayoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

    }
}
