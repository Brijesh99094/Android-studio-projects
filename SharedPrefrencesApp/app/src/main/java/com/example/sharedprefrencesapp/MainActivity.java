package com.example.sharedprefrencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button loginbutton;
    CheckBox rememberMe;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edtUsername);
        password = (EditText) findViewById(R.id.edtPassword);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        loginbutton = (Button) findViewById(R.id.btnlogin);


        pref = getSharedPreferences("MY_PREFS",MODE_PRIVATE);

        if(pref.contains("username")){
            username.setText(pref.getString("username","NA"));
            password.setText(pref.getString("password","NA"));
            rememberMe.setChecked(true);
        }

    loginbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String uname = username.getText().toString();
            String pass = password.getText().toString();
            Boolean remember = rememberMe.isChecked();

            SharedPreferences.Editor editor = pref.edit();
            if(uname.equals("") || pass.equals("")){
                Toast.makeText(MainActivity.this,"Username and password is required",Toast.LENGTH_SHORT).show();
            }else{
                if(remember){
                    editor.putString("username",uname);
                    editor.putString("password",pass);
                    editor.apply();
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this,WelComeActivity.class);
                    startActivity(intent);
                }else
                {
                    editor.remove("username");
                    editor.remove("password");
                    editor.apply();
                    editor.commit();
                }
            }
        }
    });
    }

}