package com.example.sakshamtulsyan.complaintapp;

/**
 * Created by Saksham Tulsyan on 25-04-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite {
    MyHelper helper;
    Context context;
    SQLite(Context context){
        this.context=context;
        helper=new MyHelper(context);
    }


    public Cursor showrecord(String username){
        SQLiteDatabase db=helper.getWritableDatabase();
        String[] COLUMNS={"name","email","username"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper.TABLE_NAME,COLUMNS,selection,selectionargs,null,null,null);
        return c;
    }

    public boolean validate(String username, String password){
        boolean state=false;
        SQLiteDatabase db=helper.getWritableDatabase();
        String col[]={MyHelper.USERNAME,MyHelper.PASSWORD};
        String whereClause=MyHelper.USERNAME+" = ? and "+MyHelper.PASSWORD+" = ?";
        String whereArgs[]={username,password};
        Cursor c=db.query(MyHelper.TABLE_NAME, col, whereClause, whereArgs, null, null, null);
        if(c.moveToNext()) //moving the cursor to the next row to check if the cursor has any data or not
        {
            state=true;
        }
        return state;
    }

    public long insertData(String name,String email,String username,String password){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MyHelper.NAME,name);
        values.put(MyHelper.EMAIL,email);
        values.put(MyHelper.USERNAME,username);
        values.put(MyHelper.PASSWORD,password);
        long l=db.insert(MyHelper.TABLE_NAME, null, values);
        return l;
    }


    class MyHelper extends SQLiteOpenHelper{

        private static final String DB_NAME="complaintappdb";
        private static final int DB_VERSION=1;
        private static final String TABLE_NAME="userdetails";
        private static final String NAME="name";
        private static final String EMAIL="email";
        private static final String USERNAME="username";
        private static final String PASSWORD="password";
        private static final String TABLE_CREATE="create table if not exists "+TABLE_NAME+" ("+NAME+"  varchar(20),"+EMAIL+"  varchar(20),"+USERNAME+" varchar(10),"+PASSWORD+"  varchar(20))";
        private static final String TABLE_DROP="drop table "+TABLE_NAME;


        public MyHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
        }

        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            db.execSQL(TABLE_DROP);
            onCreate(db);
        }
    }
}
