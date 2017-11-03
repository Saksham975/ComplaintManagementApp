package com.example.sakshamtulsyan.complaintapp;

/**
 * Created by Saksham Tulsyan on 29-04-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite1 {
MyHelper1 helper1;
    Context context1;
    SQLite1(Context context1){
        this.context1=context1;
        helper1=new MyHelper1(context1);
    }



    public Cursor showrecord1(String username){
        SQLiteDatabase db=helper1.getWritableDatabase();
        String[] COLUMNS={"username","type_of_complaint","complaint"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper1.TABLE_NAME1,COLUMNS,selection,selectionargs,null,null,null);
        return c;
    }


    public Cursor showcomplaints(String username){
        SQLiteDatabase db=helper1.getWritableDatabase();
        String[] COLUMNS={"username","type_of_complaint","complaint"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper1.TABLE_NAME1,COLUMNS,selection,selectionargs,null,null,null);
        return c;
    }



    public long registercomplaint(String username,String type, String complaint){
        SQLiteDatabase db=helper1.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MyHelper1.USERNAME,username);
        values.put(MyHelper1.TYPE, type);
        values.put(MyHelper1.COMPLAINT, complaint);
        long l=db.insert(MyHelper1.TABLE_NAME1,null,values);
        return l;
    }

class MyHelper1 extends SQLiteOpenHelper {
    private static final String DB_NAME1 = "complaintappdb1";
    private static final int DB_VERSION1 = 1;
    private static final String TABLE_NAME1 = "complaintdetails1";
    //private static final String NAME = "name";
    //private static final String EMAIL = "email";
    private static final String USERNAME = "username";
    //private static final String PASSWORD = "password";
    private static final String TYPE = "type_of_complaint";
    private static final String COMPLAINT = "complaint";
    private static final String TABLE_CREATE1 = "create table if not exists " + TABLE_NAME1 + " (" + USERNAME + "  varchar(20)," + TYPE + "  varchar(20)," + COMPLAINT + " varchar(200))";
    private static final String TABLE_DROP1 = "drop table " + TABLE_NAME1;

    public MyHelper1(Context context1) {
        super(context1, DB_NAME1, null, DB_VERSION1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE1);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL(TABLE_DROP1);
        onCreate(db);
    }
}
}
