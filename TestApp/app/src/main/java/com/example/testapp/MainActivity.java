package com.example.testapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btnOk,btnDial,btnList,btnCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnDial = (Button) findViewById(R.id.btnDial);
        btnList = (Button) findViewById(R.id.btnList);
        btnCapture = (Button) findViewById(R.id.btnCapture);

        btnOk.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.btnOk:
                String value = editText.getText().toString();
                i = new Intent(MainActivity.this,ShowMessage.class);
                i.putExtra("key",value);
                startActivity(i);
                break;
            case R.id.btnDial:
                i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editText.getText().toString()));
                startActivity(i);
                break;
            case R.id.btnCall:
                break;
            case R.id.btnList:
                i  = new Intent(MainActivity.this,ListActivity.class);
                startActivityForResult(i,10);
            case R.id.btnCapture:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,20);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && data.hasExtra("course")){
            Log.d("data:",data.getStringExtra("course"));
        }
        if(requestCode == 20){
            Log.d("click", "capture called ");
        }
    }
}