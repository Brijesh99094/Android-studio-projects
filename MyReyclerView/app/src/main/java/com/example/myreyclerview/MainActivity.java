package com.example.myreyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        adapter = new CustomRecyclerViewAdapter(this,movieList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}