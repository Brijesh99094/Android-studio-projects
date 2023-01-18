package com.example.zulfin.sharedprefrencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtusername, edtpassword;
    CheckBox chkremember;
    Button btnlogin;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusername = (EditText) findViewById(R.id.edtusername);
        edtpassword = (EditText) findViewById(R.id.edtpassword);

        chkremember = (CheckBox) findViewById(R.id.chkremember);
        btnlogin = (Button) findViewById(R.id.btnlogin);

//        prefs = getPreferences(MODE_PRIVATE);
        prefs = getSharedPreferences("MY_PREFS", MODE_PRIVATE);


        if(prefs.contains("username")){
            Log.d("prefs", prefs.getString("username", "NA"));
            Log.d("prefs", prefs.getString("password", "NA"));
            edtusername.setText(prefs.getString("username", ""));
            edtpassword.setText(prefs.getString("password", ""));
            chkremember.setChecked(true);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();
                Boolean chk = chkremember.isChecked();

                SharedPreferences.Editor editor = prefs.edit();

                if(username.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Username and Password must not be null.", Toast.LENGTH_SHORT).show();
                } else {
                    if(chk){
                        Toast.makeText(MainActivity.this, "Remember Me Clicked", Toast.LENGTH_SHORT).show();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.apply();
                        editor.commit();
                        Log.d("prefs", prefs.getString("username", "NA"));
                        Log.d("prefs", prefs.getString("password", "NA"));
                        Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(i);
                    } else {
                        editor.remove("username");
                        editor.remove("password");
                        editor.apply();
                        editor.commit();
                        Toast.makeText(MainActivity.this, "Remember Me not Clicked", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
