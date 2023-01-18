package com.example.zulfin.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView imgPoster2;
    TextView txtName2, txtGenre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgPoster2 = (ImageView) findViewById(R.id.imgPoster2);
        txtName2 = (TextView) findViewById(R.id.txtName2);
        txtGenre2 = (TextView) findViewById(R.id.txtGenre2);

        if(getIntent().getExtras().containsKey("movie")){
            Movie movie = (Movie) getIntent().getExtras().getSerializable("movie");

            txtName2.setText(movie.name);
            txtGenre2.setText(movie.genre);

            imgPoster2.setImageResource(getResources().getIdentifier(movie.poster, "drawable", getPackageName()));

        }
    }
}
