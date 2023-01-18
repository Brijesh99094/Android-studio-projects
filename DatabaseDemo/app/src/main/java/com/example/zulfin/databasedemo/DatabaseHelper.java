package com.example.zulfin.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Prduct_CREATE = "Create table if not exists product (id integer primary key autoincrement, name text, price double)";

    public DatabaseHelper(Context context ) {
        super(context, "SHOPPING_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Prduct_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUpdateProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", product.name);
        cv.put("price", product.price);

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
