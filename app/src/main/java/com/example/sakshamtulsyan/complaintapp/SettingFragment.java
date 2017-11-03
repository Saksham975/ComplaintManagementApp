package com.example.sakshamtulsyan.complaintapp;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    EditText e1,e2;
    Button b1;
    SQLite2 taker;
    String s=MainActivity.e1.getText().toString();

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_setting, container, false);
        getActivity().setTitle("Feedback");
        taker=new SQLite2(getActivity());
        e1=(EditText)v.findViewById(R.id.name);
        e2=(EditText)v.findViewById(R.id.feedback);
        b1=(Button)v.findViewById(R.id.feedbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long l=taker.takefeedback(e1.getText().toString(),e2.getText().toString());
                    if(l>0){
                    Toast.makeText(getContext(),"Thankyou for your Feedback",Toast.LENGTH_LONG).show();
                        e1.setText("");
                        e2.setText("");
                    }
                    else{
                        Snackbar.make(v, "Error Occurred", Snackbar.LENGTH_LONG).show();
                    }
                }
        });
        return v;
    }

}
