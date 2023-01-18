package com.example.zulfin.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewProduct extends AppCompatActivity {

    ArrayList<Product> productArrayList = new ArrayList<Product>();
    ListView productListView;
    ProductAdapter productAdapter;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);

        productListView = (ListView) findViewById(R.id.productListView);

        dbHelper = new DatabaseHelper(getApplicationContext());

        productArrayList = dbHelper.getProducts();

        Log.d("productList", productArrayList.toString());
        productAdapter = new ProductAdapter(ViewProduct.this, productArrayList);
        productListView.setAdapter(productAdapter);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = productArrayList.get(i);

                Intent intent = new Intent(ViewProduct.this, AddProduct.class);
                intent.putExtra("product", p);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_product,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.btnAdd){
            Intent intent = new Intent(ViewProduct.this,AddProduct.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productArrayList.clear();
        productArrayList.addAll(dbHelper.getProducts());
        productAdapter.notifyDataSetChanged();
    }
}
