package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> todoItems;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        todoItems = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, todoItems);
        listView.setAdapter(arrayAdapter);

        todoItems.add("MCA 3");
        todoItems.add("MCA 5");
        todoItems.add("M.Tech 3");
        arrayAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Log.i("Hello!", todoItems.get(position));
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                i.putExtra("course", todoItems.get(position));
//                startActivity(i);
                //startActivityForResult(i, 10);
                setResult(10, i);
                finish();
            }

        });
    }
}
