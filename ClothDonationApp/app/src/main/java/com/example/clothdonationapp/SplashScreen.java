package com.example.clothdonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        User user = new User(SplashScreen.this);


            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.getUsername()!="" && user.getUserType().equals("Admin")){
                    Intent iHome=new Intent(SplashScreen.this,HomeActivity.class);
                    startActivity(iHome);
                    finish();
                }
                else if(user.getUsername()!="" && user.getUsername().equals("Donor"))
                {
                    Intent iHome=new Intent(SplashScreen.this,DonorActivity.class);
                    startActivity(iHome);
                    finish();
                }
                else{
                    Intent iHome=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(iHome);
                    finish();
                }

            }
        },3000);
    }
}