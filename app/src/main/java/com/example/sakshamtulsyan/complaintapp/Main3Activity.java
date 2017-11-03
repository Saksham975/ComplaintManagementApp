package com.example.sakshamtulsyan.complaintapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    TextView loginScreen;
    Button b1;
    SQLite inserter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        inserter=new SQLite(this);
        setTitle("Register");
        loginScreen=(TextView)findViewById(R.id.loginscreen);
        e1=(EditText)findViewById(R.id.namebar);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.username);
        e4=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.feedbutton);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name=e1.getText().toString();
                String email=e2.getText().toString();
                String username=e3.getText().toString();
                String password=e4.getText().toString();
                long l=inserter.insertData(name,email,username,password);
                if(l>0){
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    Toast.makeText(getBaseContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(),"Error Occurred",Toast.LENGTH_LONG).show();
                }
        }
    });
        loginScreen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               finish();
            }
        });
}
}
