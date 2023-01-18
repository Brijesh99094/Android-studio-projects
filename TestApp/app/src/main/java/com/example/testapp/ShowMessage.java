package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowMessage extends AppCompatActivity {

    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
        textView = (TextView) findViewById(R.id.textView);

        if(getIntent().getExtras().containsKey("key")){
            String val = getIntent().getStringExtra("key");
            textView.setText(val);
        }
    }
}