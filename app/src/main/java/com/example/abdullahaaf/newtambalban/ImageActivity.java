package com.example.abdullahaaf.newtambalban;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by abdullahaaf on 11/29/16.
 */

public class ImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
    }
    public void returnToMainActivity(View v){
        startActivity(new Intent(getApplicationContext(),
                MainActivityMaps.class));
    }
}
