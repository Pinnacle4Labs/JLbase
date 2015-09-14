package com.example.myultra.gmap10;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//INITIALIZING 
    Button map_btn,b2,btn_map1;
    double longitude,latitude;
    EditText e,e2,e3;
    List<Address> addresses = null;
    Geocoder geocoder;
    private static LatLng DAVAO ;
    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// INTANCES MADE 
        map_btn=(Button) findViewById(R.id.button);
        map_btn.setOnClickListener(this);
        b2=(Button) findViewById(R.id.button2);
        e=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        btn_map1=(Button) findViewById(R.id.btn_map1);

//GEOCODER IS USED TO GET THE LOCATION
        geocoder = new Geocoder(this, Locale.getDefault());

    }

//THIS FUNTION WILL USE ADDRESS TO FETCH THE LAT LONG ON THAT PARTICULAR ADDRESS
    @Override
    public void onClick(View v) {
            try {
                addresses = geocoder.getFromLocationName(e.getText().toString(), 1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Address address = addresses.get(0);
              longitude = address.getLongitude();
              latitude = address.getLatitude();

           e2.setText(String.valueOf(latitude));
           e3.setText(String.valueOf(longitude));
        }

//THIS FUNTION WILL GET THE LAT LONG FROM EDITTEXT AND USE IT ON GEOCODER TO FETCH ADDRESS ON THAT PARTICLAR LOCATION

    public  void fetchAddress(View view) throws IOException {
        latitude = Double.parseDouble(e2.getText().toString());
        longitude = Double.parseDouble(e3.getText().toString());
        geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        Address address;
        String result = null;
        List<Address> list = geocoder.getFromLocation(latitude, longitude, 1);
        address = list.get(0);
        result = address.getAddressLine(0) + ", " + address.getLocality();
        e.setText(result);
    }


// THIS FUNTION WILL BUNDLE THE LATITUDE AND LONGITUDE FOR MAIN2ACTIVITY
    public void coordinate(View view)
    {
        Intent intent=new Intent(getApplication(),Main2Activity.class);
        intent.putExtra("latitude",latitude);
        intent.putExtra("longitude",longitude);
        startActivity(intent);
    }
}
