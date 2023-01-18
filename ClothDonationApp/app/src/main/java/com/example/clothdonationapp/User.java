package com.example.clothdonationapp;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    Context context;
    private  String username;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String userType;

    public  void  removeUser(){
        sharedPreferences.edit().clear().commit();
    }

    public String getUsername() {
        username = sharedPreferences.getString("userdata","");
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        sharedPreferences.edit().putString("userdata",username).commit();
    }

    SharedPreferences sharedPreferences;
    public  User(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);

    }
}
