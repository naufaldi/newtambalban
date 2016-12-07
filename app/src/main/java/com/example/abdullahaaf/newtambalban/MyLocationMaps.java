package com.example.abdullahaaf.newtambalban;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.abdullahaaf.newtambalban.R.id.map;

public class MyLocationMaps extends FragmentActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final LatLng BendunganSutami = new LatLng(-7.9603264,112.6114648);
    private static final LatLng Kedawung = new LatLng(-7.9509526,112.6298283);
    private static final LatLng Tlogomas = new LatLng(-7.9292906,112.5791179);
    private static final LatLng Tlogomas2 = new LatLng(-7.9256673,112.5986579);
    private static final LatLng Siguragura = new LatLng(-7.9579116,112.6075216);
    private static final LatLng Sungkono = new LatLng(-7.9996802,112.6423525 );
    private static final LatLng RanuJati = new LatLng(-7.978953,112.6503452);
    private static final LatLng SiguraMotor = new LatLng(-7.9577964,112.6100215);
    private static final LatLng Bendungan = new LatLng(-7.9562955,112.6130176);
    private static final LatLng Sutami2 = new LatLng(-7.9601787,112.6132525);
    private static final LatLng PurnamaBan = new LatLng(-7.938236,112.6118525);
    private static final LatLng Mtharyono = new LatLng(-7.9440913,112.60975);
    private static final LatLng Gajayana = new LatLng(-7.9476143,112.607728);
    private static final LatLng Kertoseno = new LatLng(-7.9482043,112.60805);
    private static final LatLng Teknik = new LatLng(-7.9511793,112.612052);
    private static final LatLng SimpangAmbarawa = new LatLng(-7.9613283,112.61401);
    private static final LatLng Windal = new LatLng(-7.9601487,112.6085905);
    /**
     * Request code for location permission request.
     *
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    /**
     * Flag indicating whether a requested permission has been denied after returning in
     * {@link #onRequestPermissionsResult(int, String[], int[])}.
     */
    private boolean mPermissionDenied = false;

    private GoogleMap mMap;
    private Marker mSelectedMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location_maps);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        // Hide the zoom controls.
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
        // Add lots of markers to the map.
        addMarkersToMap();

        // Set listener for marker click event.  See the bottom of this class for its behavior.
        mMap.setOnMarkerClickListener(this);

        // Set listener for map click event.  See the bottom of this class for its behavior.
        mMap.setOnMapClickListener(this);

        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localized.
        map.setContentDescription("Demo Tambal Ban"
                + " Selected Marker");

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(BendunganSutami)
                .include(Kedawung)
                .include(Tlogomas)
                .include(Tlogomas2)
                .include(Siguragura)
                .include(Sungkono)
                .include(RanuJati)
                .include(SiguraMotor)
                .include(Bendungan)
                .include(Sutami2)
                .include(PurnamaBan)
                .include(Mtharyono)
                .include(Windal)
                .include(SimpangAmbarawa)
                .include(Teknik)
                .include(Kertoseno)
                .include(Gajayana)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));
    }
    private void addMarkersToMap() {
        mMap.addMarker(new MarkerOptions()
                .position(BendunganSutami)
                .title("Tambal Ban Perbaikan")
                .snippet("Motor dan Sepeda"));

        mMap.addMarker(new MarkerOptions()
                .position(Kedawung)
                .title("Tambal Ban PGT")
                .snippet("Motor dan Sepeda"));

        mMap.addMarker(new MarkerOptions()
                .position(Tlogomas)
                .title("Tambal Ban Mbah Azzik")
                .snippet("Motor dan Sepeda"));

        mMap.addMarker(new MarkerOptions()
                .position(Tlogomas2)
                .title("Tambal Ban Taufiq")
                .snippet("Sepeda"));

        mMap.addMarker(new MarkerOptions()
                .position(Siguragura)
                .title("Tambal Ban Sigura")
                .snippet("Motor"));
        mMap.addMarker(new MarkerOptions()
                .position(Sungkono)
                .title("Tambal Ban Sungkono")
                .snippet("Jual Ban dan Reparasi"));
        mMap.addMarker(new MarkerOptions()
                .position(RanuJati)
                .title("Tambal Ban RanuJati")
                .snippet("Motor dan Jual Ban"));
        mMap.addMarker(new MarkerOptions()
                .position(SiguraMotor)
                .title("Tambal Ban Kasmudin")
                .snippet("Reparasi dan Servis"));
        mMap.addMarker(new MarkerOptions()
                .position(Bendungan)
                .title("Tambal Ban SukoMoro")
                .snippet("Sepeda dan Motor"));
        mMap.addMarker(new MarkerOptions()
                .position(Sutami2)
                .title("Tambal Ban Anjar")
                .snippet("Jual Ban dan Motor"));
        mMap.addMarker(new MarkerOptions()
                .position(PurnamaBan)
                .title("Tambal Ban Riyanto")
                .snippet("Motor dan Mobil"));
        mMap.addMarker(new MarkerOptions()
                .position(Mtharyono)
                .title("Tambal Ban BangKowi")
                .snippet("Motor dan Mobil"));
        mMap.addMarker(new MarkerOptions()
                .position(Windal)
                .title("Tambal Ban Windal")
                .snippet("Reparasi dan Servis"));
        mMap.addMarker(new MarkerOptions()
                .position(SimpangAmbarawa)
                .title("Tambal Ban Ambarawa")
                .snippet("Sepeda dan Motor"));
        mMap.addMarker(new MarkerOptions()
                .position(Teknik)
                .title("Tambal Ban Teknik")
                .snippet("Servis Premium Motor"));
        mMap.addMarker(new MarkerOptions()
                .position(Kertoseno)
                .title("Tambal Ban Kertoseno")
                .snippet("Jual Beli Motor dan Tambal Ban"));
        mMap.addMarker(new MarkerOptions()
                .position(Gajayana)
                .title("Tambal Ban Gajayana")
                .snippet("Reparasi dan Tambal Motor"));
    }
    @Override
    public void onMapClick(final LatLng point) {
        // Any showing info window closes when the map is clicked.
        // Clear the currently selected marker.
        mSelectedMarker = null;
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        // The user has re-tapped on the marker which was already showing an info window.
        if (marker.equals(mSelectedMarker)) {
            // The showing info window has already been closed - that's the first thing to happen
            // when any marker is clicked.
            // Return true to indicate we have consumed the event and that we do not want the
            // the default behavior to occur (which is for the camera to move such that the
            // marker is centered and for the marker's info window to open, if it has one).
            mSelectedMarker = null;
            return true;
        }

        mSelectedMarker = marker;

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur.
        return false;
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    android.Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);


        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();

        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }
    public void returnToMainActivity(View v){
        startActivity(new Intent(getApplicationContext(),
                MainActivityMaps.class));
    }


}
