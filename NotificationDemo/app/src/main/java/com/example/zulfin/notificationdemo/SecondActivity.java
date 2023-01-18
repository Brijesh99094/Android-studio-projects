package com.example.zulfin.notificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtMsg.setText("Your result is : " + getIntent().getAction());
    }
}
