package com.example.sakshamtulsyan.complaintapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Saksham Tulsyan on 02-05-2017.
 */
public class SQLiteImage {
    MyHelper helper;
    Context context;

    SQLiteImage(Context context) {
        this.context = context;
        helper = new MyHelper(context);
    }


    public void insertData(String username, String name, String issue, byte[] image){
        SQLiteDatabase database=helper.getWritableDatabase();
        String sql="INSERT INTO IMAGE VALUES (NULL,?,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, username);
        statement.bindString(2,name);
        statement.bindString(3,issue);
        statement.bindBlob(4,image);
        statement.executeInsert();
    }


    public Cursor showrecord1(String username){
        SQLiteDatabase db=helper.getWritableDatabase();
        String[] COLUMNS={"username","name","issue"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper.TABLE_NAME,COLUMNS,selection,selectionargs,null,null,null);
        return c;
    }



    public Cursor getData1(String username){
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] COLUMNS={"username","name","issue"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper.TABLE_NAME,COLUMNS,selection,selectionargs,null,null,null);
        return c;
    }



    public Cursor getimage(String username){
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] COLUMNS={"image"};
        String selection="username =?";
        String[] selectionargs={username};
        Cursor c=db.query(MyHelper.TABLE_NAME, COLUMNS, selection, selectionargs, null, null, null);
        return c;
    }


    class MyHelper extends SQLiteOpenHelper {

        private static final String DB_NAME="complaintappdbimg";
        private static final int DB_VERSION=1;
        private static final String IMG_ID="id";
        private static final String TABLE_NAME="IMAGE";
        private static final String USERNAME="username";
        private static final String ISSUE="issue";
        private static final String NAME="name";
        private static final String IMAGE="image";
        private static final String TABLE_CREATE="create table if not exists "+TABLE_NAME+" ("+IMG_ID+" integer,"+USERNAME+"  varchar(20),"+NAME+" varchar(20),"+ISSUE+" varchar(200), "+IMAGE+" blob not null)";
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
