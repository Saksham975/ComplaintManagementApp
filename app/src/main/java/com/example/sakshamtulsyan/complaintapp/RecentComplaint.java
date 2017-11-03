package com.example.sakshamtulsyan.complaintapp;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecentComplaint extends Fragment {
SQLite1 shower1;
    SQLiteImage showimg,showimg1;
    TextView t1,t2,t3,t4,t5,t6;
    ImageView imageView;
    String s=MainActivity.e1.getText().toString();
    public RecentComplaint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_recent_complaint, container, false);
        getActivity().setTitle("Recent Complaints");
        shower1=new SQLite1(getActivity());
        showimg=new SQLiteImage(getActivity());
        showimg1=new SQLiteImage(getActivity());
        String[] types=new String[100];
        String[] complaints=new String[100];
        ArrayList<Bitmap> imglist=new ArrayList<Bitmap>();
        int i1=0;
        int i2=0;
        int i3=0;
        Cursor cursor=showimg.getData1(s);

        while(cursor.moveToNext()){
            types[i1++]=cursor.getString(1);
            complaints[i2++]=cursor.getString(2);
        }

        /*Cursor cursor1=showimg1.getimage(s);

        while (cursor1.moveToFirst()){
            byte[] img=cursor1.getBlob(0);
            Bitmap bitmap=BitmapFactory.decodeByteArray(img,0,img.length);
            imageView.setImageBitmap(bitmap);
        }*/


        t1=(TextView)v.findViewById(R.id.type1);
        t2=(TextView)v.findViewById(R.id.comp1);
        t3=(TextView)v.findViewById(R.id.type2);
        t4=(TextView)v.findViewById(R.id.comp2);
        t5=(TextView)v.findViewById(R.id.type3);
        t6=(TextView)v.findViewById(R.id.comp3);
        t1.setText(types[i1-1]);
        t2.setText(complaints[i2-1]);
        t3.setText(types[i1-2]);
        t4.setText(complaints[i2-2]);
        t5.setText(types[i1-3]);
        t6.setText(complaints[i2-3]);
        //imageView.setImageBitmap(imglist.get(0));
        return v;
    }

}
