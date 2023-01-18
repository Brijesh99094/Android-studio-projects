package com.example.zulfin.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    Button btnSave, btnDelete;
    EditText edtProduct, edtPrice;
    Product product = new Product();
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        edtProduct = (EditText) findViewById(R.id.edtProduct);
        edtPrice = (EditText) findViewById(R.id.edtPrice);

        dbHelper = new DatabaseHelper(getApplicationContext());

        if(getIntent().hasExtra("product")){
            product = (Product) getIntent().getExtras().getSerializable("product");
            edtProduct.setText(product.name);
            edtPrice.setText(product.price + "");
        } else {
            btnDelete.setVisibility(View.GONE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                product.name = edtProduct.getText().toString();
                product.price = Integer.parseInt(edtPrice.getText().toString());

                if(dbHelper.addUpdateProduct(product) == true){
                    Toast.makeText(AddProduct.this, "Product added or updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddProduct.this, "Product not added or updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbHelper.deleteProduct(product.id) == true){
                    Toast.makeText(AddProduct.this, "Product deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddProduct.this, "Product not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
