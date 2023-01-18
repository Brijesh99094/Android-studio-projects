package com.example.zulfin.filedemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText edtInternalfile, edtExternalfile;
    Button btnInternal, btnExternal;
    File file, fileExternal, folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInternalfile = (EditText) findViewById(R.id.edtInternalfile);
        edtExternalfile = (EditText) findViewById(R.id.edtExternalfile);

        btnInternal = (Button) findViewById(R.id.btnInternal);
        btnExternal = (Button) findViewById(R.id.btnExternal);

        file = new File(getFilesDir(), "Demo.txt");

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
        } else {
            try {
                //        folder = new File(Environment.getExternalStorageDirectory()+ File.separator +  "Download" + File.separator + "DemoApp");
                fileExternal = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Download" + File.separator + "Notes.txt");
                 if(fileExternal.exists()){
                     Toast.makeText(MainActivity.this, "Notes.txt exist.", Toast.LENGTH_SHORT).show();
                     FileInputStream fin = null;
                     try {
                         fin = new FileInputStream(fileExternal);

                         BufferedReader buf = new BufferedReader(new InputStreamReader(fin));
                         String data = "", line = "";
                         while ((line = buf.readLine())!= null){
                             data += line;
                         }
                         edtExternalfile.setText(data);
                         buf.close();
                         fin.close();
                     } catch (FileNotFoundException e) {
                         e.printStackTrace();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 } else {
                     Toast.makeText(MainActivity.this, "Notes.txt not exist.", Toast.LENGTH_SHORT).show();
                 }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if(file.exists()){
            Toast.makeText(MainActivity.this, "Demo.txt exist.", Toast.LENGTH_SHORT).show();
            FileInputStream fin = null;
            try {
                fin = new FileInputStream(file);

                BufferedReader buf = new BufferedReader(new InputStreamReader(fin));
                String data = "", line = "";
                while ((line = buf.readLine())!= null){
                    data += line;
                }
                edtInternalfile.setText(data);
                buf.close();
                fin.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
                Toast.makeText(MainActivity.this, "Demo.txt not exist.", Toast.LENGTH_SHORT).show();
        }


        btnInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    OutputStreamWriter out = new OutputStreamWriter(fos);
                    out.append(edtInternalfile.getText().toString());
                    out.close();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("btn", "btnExt clicked");
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    try {
                        FileOutputStream fos = new FileOutputStream(fileExternal);
                        OutputStreamWriter out = new OutputStreamWriter(fos);
                        out.append(edtExternalfile.getText().toString());
                        out.close();
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
