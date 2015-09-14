package com.example.myultra.gmap10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main2Activity extends AppCompatActivity {

    private static LatLng DAVAO ;
    private GoogleMap map;
    double longitude,latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        
// INTENT USED TO UNBUNDLE THE SENT DATA 
        Intent intent=getIntent();
        longitude=intent.getDoubleExtra("longitude",longitude);
        latitude=intent.getDoubleExtra("latitude",latitude);
        DAVAO = new LatLng(latitude, longitude);
// MAP FRAGMENT IS USED TO SHOW THE LOCATION ON GOOGLE MAPS 
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    Marker davao = map.addMarker(new MarkerOptions().position(DAVAO));
    // zoom in the camera to Davao city
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(DAVAO, 15));
    // animate the zoom process
    map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


/*
        try {
            if (map == null) {
                map = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            Marker TP = map.addMarker(new MarkerOptions().
                    position(DAVAO).title("position"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
