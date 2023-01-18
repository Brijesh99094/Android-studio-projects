package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Movie> movieList = new ArrayList<>();
    CustomRecyclerVIew adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        movieList.add(new Movie(1,"Panther","Action","Poster1"));
        movieList.add(new Movie(2,"Spiderman","Action","Poster2"));
        movieList.add(new Movie(3,"Bat man","Action","Poster3"));
        movieList.add(new Movie(4,"Aqua man","Action","Poster4"));
        movieList.add(new Movie(5,"Iron man","sextion","Poster5"));


        adapter = new CustomRecyclerVIew(this,movieList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}