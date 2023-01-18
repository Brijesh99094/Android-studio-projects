package com.example.zulfin.sharedprefrencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    SharedPreferences prefs, settingsPrefs;
    TextView txtprefs, txtsettingspref;
    Button btnsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtprefs = (TextView) findViewById(R.id.txtprefs);
        txtsettingspref = (TextView) findViewById(R.id.txtsettingsprefs);

        btnsettings = (Button) findViewById(R.id.btnsettings);

//        prefs = getPreferences(MODE_PRIVATE);
        prefs = getSharedPreferences("MY_PREFS", MODE_PRIVATE);
//
        if(prefs.contains("username")){
            txtprefs.setText("Welcome " + prefs.getString("username", "NA"));
        }

        btnsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });

        settingsPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor editor = settingsPrefs.edit();
        editor.putString("edtusername", prefs.getString("username", "No Name"));
        editor.apply();
        editor.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        String edtusername = settingsPrefs.getString("edtusername", "No Value");
        String gender = settingsPrefs.getBoolean("gender", false)?"Male":"Female";
        txtsettingspref.setText(edtusername+ " " + gender);
    }
}
