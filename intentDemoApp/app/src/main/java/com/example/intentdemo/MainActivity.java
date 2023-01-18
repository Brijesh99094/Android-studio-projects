package com.example.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnDial, btnCall, btnWebsite, btnMap, btnList, btnStorage, btnCapture,btnsayHello;
    ImageView imgpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnDial =(Button) findViewById(R.id.btnDialer);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnWebsite = (Button) findViewById(R.id.btnWebsite);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnList = (Button) findViewById(R.id.btnList);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnCapture = (Button) findViewById(R.id.btnCapture);
        btnsayHello = (Button) findViewById(R.id.btnsayHello);
        imgpic = (ImageView) findViewById(R.id.imgpic);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + editText.getText().toString()));
                startActivity(i);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText().toString()));

                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.INTERNET},
                            1);
                } else {
                    try {
                        startActivity(i);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://" + editText.getText().toString()));
                startActivity(i);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + editText.getText().toString() + ",21.28"));
                startActivity(i);
            } // it's not working perfectly .....
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                //startActivity(i);
                startActivityForResult(i,10);
            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,20);
            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,30);
            }
        });

        btnsayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("lifecycle","SayHelloCalled");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 20){
            imgpic.setImageURI(data.getData());
        }
    }
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("intentResult", requestCode + " " + resultCode);
//
//        if(requestCode == 10 && data.hasExtra("course")) {
//            Log.d("intentResult", data.hasExtra("course") + "");
//
//            Log.d("intentResult", data.getStringExtra("course") + "");
//        }
//        if(requestCode == 20 ){
//            Log.d("intentResult", data.toString());
//            imgpic.setImageURI(data.getData());
//        }
//        if(requestCode == 30){
//            Log.d("intentResult", data.getExtras().get("data").toString());
//
//            Bitmap btmp = (Bitmap) data.getExtras().get("data");
//            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//
//            btmp.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//            imgpic.setImageBitmap(btmp);
//        }
//
//    }
}