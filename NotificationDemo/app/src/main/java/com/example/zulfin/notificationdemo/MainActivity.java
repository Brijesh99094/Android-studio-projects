package com.example.zulfin.notificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTitle, edtSubTitle;
    Button btntype1, btntype2, btntype3, btnclear;
    NotificationHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtSubTitle = (EditText) findViewById(R.id.edtSubTitle);

        btntype1 = (Button) findViewById(R.id.btntype1);
        btntype2 = (Button) findViewById(R.id.btntype2);
        btntype3 = (Button) findViewById(R.id.btntype3);
        btnclear = (Button) findViewById(R.id.btnclear);

        btntype1.setOnClickListener(this);
        btntype2.setOnClickListener(this);
        btntype3.setOnClickListener(this);
        btnclear.setOnClickListener(this);

        helper = new NotificationHelper(getApplicationContext());

    }

    @Override
    public void onClick(View view) {
        Log.d("btnCLick", view.getId() + "");
        switch (view.getId()){
            case R.id.btntype1:
                Log.d("btnCLick", "Type 1 Clicked");
                helper.Type1Notification(edtTitle.getText().toString(), edtSubTitle.getText().toString());
                break;
            case R.id.btntype2:
                Log.d("btnCLick", "Type 2 Clicked");
                helper.Type2Notification(edtTitle.getText().toString(), edtSubTitle.getText().toString());
                break;
            case R.id.btntype3:
                Log.d("btnCLick", "Type 3 Clicked");
                helper.Type3Notification(edtTitle.getText().toString(), edtSubTitle.getText().toString());
                break;
            case R.id.btnclear:
                Log.d("btnCLick", "Clear Clicked");
                helper.clearNotification();
                break;
        }
    }
}
