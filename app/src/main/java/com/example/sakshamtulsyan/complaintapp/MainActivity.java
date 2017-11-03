package com.example.sakshamtulsyan.complaintapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    static EditText e1; EditText e2;
    Button b1;
    TextView registerScreen;
    SQLite checker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checker=new SQLite(this);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.pass1);
        registerScreen=(TextView)findViewById(R.id.register);
        b1=(Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=e1.getText().toString();
                String password=e2.getText().toString();
                boolean flag=checker.validate(username,password);
                if(flag==true){
                    Intent in = new Intent(getApplicationContext(), Main4Activity.class);
                    in.putExtra("username", username);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getBaseContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
        registerScreen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i1=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i1);
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
}
