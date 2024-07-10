package com.example.myapplications;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
   public DBHelper(Context context){
       super(context,"Users.db",null,1);
   }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Userdetail(name TEXT primary key,contact TEXT,dob TEXT,date TEXT,time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Userdetail");
    }
    public Boolean insertuserdata(String name,String contact,String dob,String time,String date){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("Time", time);
        contentValues.put("Date", date);

        long result=DB.insert("Userdetail",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean updateuserdata(String name,String contact,String dob,String time,String date){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("Time", time);
        contentValues.put("Date", date);

        Cursor cursor=DB.rawQuery("Select * from userdetail where name = ?",new String [] {name});
        if(cursor.getCount()>0) {
            long result = DB.update("Userdetail", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }
    public Boolean deleteuserdata(String name){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userdetail where name = ?",new String [] {name});
        if(cursor.getCount()>0) {
            long result = DB.delete("Userdetail", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }
    public Cursor viewuserdata(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userdetail ",null);
        return cursor;
    }


}
