package com.example.clothdonationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public  static  final String DBNAME = "cloth_donation_app.db";

    public DbHelper(Context context){
        super(context,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDb) {
        MyDb.execSQL("create table if not exists user(username TEXT primary key ,password TEXT , type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDb, int i, int i1) {
        MyDb.execSQL("Drop table if exists user");
    }

    public Boolean insertData(String username,String password,String type){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("type",type);
        long result  = MyDb.insert("user",null,contentValues);

        if(result == -1){
            return  false;
        }
        else{
            return  true;
        }
    }


    public Boolean checkUsername(String username){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor =     MyDb.rawQuery("select * from user where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return  false;
        }
    }

    public Boolean checkUsernameAndPassword(String username,String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor =     MyDb.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return  false;
        }
    }

    public  String getTypeOfUser(String username,String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor =     MyDb.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        cursor.moveToNext();
        String type_of_user =  "";
        type_of_user = cursor.getString(2);
        return type_of_user;
    }
}
