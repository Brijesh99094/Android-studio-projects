package com.example.dbapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String  Product_Create = "create table if not exists Product(id integer primary key,autoincrement ,name text,price double) ";


    public DbHelper(@Nullable Context context) {
        super(context,"Shopping_DB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Product_Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean AddUpdateProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",product.name);
        cv.put("price",product.price);
        if(product.id == 0){
            db.insertOrThrow("product", null, cv);
            db.close();
            return true;
        } else {
            db.update("product", cv, "id=?", new String[]{product.id + ""});
            db.close();
            return true;
        }

    }

    public boolean deleteProduct(Long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("product", "id=?", new String[]{id + ""});
        db.close();
        return false;
    }


    public ArrayList<Product> getProducts(){
        ArrayList<Product> productList = new ArrayList<Product>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from product", null);
        if(c.getCount() > 0){
            c.moveToFirst();
            while (c.moveToNext()){
                Product p = new Product();
                p.id = c.getLong(c.getColumnIndex("id"));
                p.name = c.getString(c.getColumnIndex("name"));
                p.price = c.getDouble(c.getColumnIndex("price"));

                productList.add(p);

            }
        }

        db.close();
        return productList;
    }

}
