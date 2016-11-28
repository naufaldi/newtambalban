package com.example.abdullahaaf.newtambalban;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by abdullahaaf on 11/29/16.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    double latitude = 0;
    double longitude = 0;
    LatLng lokasi1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent intent = getIntent();
        latitude = Double.valueOf(intent.getStringExtra("Latitude"));
        longitude = Double.valueOf(intent.getStringExtra("Longitude"));
        lokasi1 = new LatLng(latitude, longitude);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_satu);
        mapFragment.getMapAsync(this);

    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(GoogleMap map) {

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi1, 18));

        map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Mukidi Tambal Ban"));
    }
    public void returnToMainActivity(View v){
        startActivity(new Intent(getApplicationContext(),
                MainActivityMaps.class));
    }
}
