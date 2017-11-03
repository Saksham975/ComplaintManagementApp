package com.example.sakshamtulsyan.complaintapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    TextView name,email,username,count;
    String s=MainActivity.e1.getText().toString();
    SQLite shower;
    SQLite1 shower1;
    SQLiteImage imager;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Profile");
        name=(TextView)v.findViewById(R.id.namebar);
        email=(TextView)v.findViewById(R.id.email);
        username=(TextView)v.findViewById(R.id.username);
        count=(TextView)v.findViewById(R.id.count);
        shower=new SQLite(getActivity());
        imager=new SQLiteImage(getActivity());
        Cursor c1= shower.showrecord(s);
        while(c1.moveToNext()){
            name.setText(c1.getString(0));
            email.setText(c1.getString(1));
            username.setText(c1.getString(2));
        }
        int count1=0;
        shower1=new SQLite1(getActivity());
        Cursor c2=imager.showrecord1(s);
        while(c2.moveToNext()){
            c2.getString(0);
            c2.getString(1);
            c2.getString(2);
            count1++;
        }
        count.setText(count1+"");
        return v;
    }

}
