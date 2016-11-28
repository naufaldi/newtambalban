package com.example.abdullahaaf.newtambalban;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by abdullahaaf on 11/29/16.
 */

public class MainActivityMaps extends Activity implements LocationListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_maps);

        ImageView mainImageView;

        mainImageView = (ImageView)findViewById(R.id.imageview);
        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),
                        ImageActivity.class));
            }
        });
        Button map_satu=(Button)findViewById(R.id.map_satu);
        Button map_dua=(Button)findViewById(R.id.map_dua);
        map_satu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i =new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("Latitude","-7.9573868");
                i.putExtra("Longitude","112.6089187");
                startActivity(i);
            }

        });
        map_dua.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i =new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("Latitude","-7.9456216");
                i.putExtra("Longitude","112.6074063");
                startActivity(i);
            }

        });
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
