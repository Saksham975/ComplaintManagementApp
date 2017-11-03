package com.example.sakshamtulsyan.complaintapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Saksham Tulsyan on 29-04-2017.
 */
public class SQLite2 {
    MyHelper2 helper2;
    Context context2;
    SQLite2(Context context2){
        this.context2=context2;
        helper2=new MyHelper2(context2);
    }


    public long takefeedback(String name,String feedback){
        SQLiteDatabase db=helper2.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MyHelper2.NAME,name);
        values.put(MyHelper2.FEEDBACK, feedback);
        long l=db.insert(MyHelper2.TABLE_NAME2,null,values);
        return l;
    }

    class MyHelper2 extends SQLiteOpenHelper {
        private static final String DB_NAME2 = "complaintappdb2";
        private static final int DB_VERSION2 = 1;
        private static final String TABLE_NAME2 = "feedbackdetails1";
        private static final String NAME = "name";
        private static final String FEEDBACK = "feedback";
        private static final String TABLE_CREATE2 = "create table if not exists " + TABLE_NAME2 + " (" + NAME + "  varchar(20)," + FEEDBACK + "  varchar(100))";
        private static final String TABLE_DROP2 = "drop table " + TABLE_NAME2;

        public MyHelper2(Context context2) {
            super(context2, DB_NAME2, null, DB_VERSION2);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE2);
        }

        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            db.execSQL(TABLE_DROP2);
            onCreate(db);
        }
    }
}
