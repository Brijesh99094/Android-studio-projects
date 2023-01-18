package com.example.zulfin.databasedemo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    ArrayList<Product> productList;
    Activity activity;

    public ProductAdapter(Activity activity, ArrayList<Product> productList) {
        super(activity, R.layout.custom_product, productList);
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View view = activity.getLayoutInflater().inflate(R.layout.custom_product, parent, false);

         Product p = productList.get(position);
        TextView txtProduct = (TextView) view.findViewById(R.id.txtProduct);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtPrice);

        txtProduct.setText(p.name);
        txtPrice.setText(p.price + " /-");

         return view;
    }
}
