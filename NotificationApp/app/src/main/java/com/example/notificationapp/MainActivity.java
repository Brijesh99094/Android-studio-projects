package com.example.notificationapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4;
    EditText title,subtitle;
    NotificationHelper helper;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.txtTitle) ;
        subtitle = (EditText) findViewById(R.id.txtsubTitle) ;

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        helper = new NotificationHelper(getApplicationContext());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                helper.Type1Notification(title.getText().toString(),subtitle.getText().toString());
                break;
            case R.id.btn2:
                helper.Type2Notification(title.getText().toString(),subtitle.getText().toString());
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                helper.clearNotificaitons();
                break;
        }
    }
}