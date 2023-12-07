package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.Dbhelper;

public class UserDAO {
    Dbhelper dbhelper;
    public UserDAO(Context context){

        dbhelper = new Dbhelper(context);
    }
    //login
    public boolean checkLogin(String username,String password) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE user=? AND pass=?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    //register
    public boolean register(String user, String pass, String email){
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("pass", pass);
        contentValues.put("email", email);
        long result = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
}
