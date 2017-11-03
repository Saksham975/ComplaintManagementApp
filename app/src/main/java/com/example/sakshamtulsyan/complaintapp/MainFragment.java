package com.example.sakshamtulsyan.complaintapp;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class MainFragment extends Fragment {
    EditText e1;
    String aa11;
    String type;
    Button b1, b2;
    Spinner sp1;
    static ImageView img;
    static final int PICK_IMAGE = 100;
    SQLite1 inserter, shower1;
    public static SQLiteImage imager;
    String s = MainActivity.e1.getText().toString();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        inserter = new SQLite1(getActivity());
        imager = new SQLiteImage(getActivity());
        getActivity().setTitle("Register Complaint");
        e1 = (EditText) v.findViewById(R.id.issue);
        sp1 = (Spinner) v.findViewById(R.id.spinner);
        ArrayList<String> a = new ArrayList<>();
        a.add("Hostel");
        a.add("Mess");
        a.add("WiFi");
        a.add("Library");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, a);
        sp1.setAdapter(arrayAdapter);
        type = sp1.getSelectedItem().toString();

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                aa11 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        img = (ImageView) v.findViewById(R.id.imageView3);
        b2 = (Button) v.findViewById(R.id.button);
        b1 = (Button) v.findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    imager.insertData(s, aa11, e1.getText().toString(), imagetobyte(img));
                    Toast.makeText(getContext(),"Complaint Registered",Toast.LENGTH_LONG).show();
                    e1.setText("");
                    img.setImageResource(R.mipmap.ic_launcher);

                }catch (Exception e){Toast.makeText(getContext(),"Please give all the required details",Toast.LENGTH_LONG).show();}

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        return v;
    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContext().getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] imagetobyte(ImageView image){
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }
}