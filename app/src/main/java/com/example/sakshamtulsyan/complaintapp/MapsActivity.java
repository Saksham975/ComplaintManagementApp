package com.example.sakshamtulsyan.complaintapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng rcp1 = new LatLng(12.9722, 79.1384);
        mMap.addMarker(new MarkerOptions().position(rcp1).title("Katpadi Junction"));
        LatLng rcp2 = new LatLng(12.9219, 79.1325);
        mMap.addMarker(new MarkerOptions().position(rcp2).title("Old Bus Stand"));
        LatLng rcp3 = new LatLng(12.9343, 79.1377);
        mMap.addMarker(new MarkerOptions().position(rcp3).title("New Bus Stand"));
        LatLng rcp4 = new LatLng(12.9693, 79.1559);
        mMap.addMarker(new MarkerOptions().position(rcp4).title("VIT University, Vellore"));
        LatLng rcp5 = new LatLng(12.8409, 80.153);
        mMap.addMarker(new MarkerOptions().position(rcp5).title("VIT University, Chennai"));
        LatLng rcp6 = new LatLng(12.9941, 80.1709);
        mMap.addMarker(new MarkerOptions().position(rcp6).title("Chennai Airport"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp4));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp5));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rcp6));
    }
}