package com.example.abdullahaaf.newtambalban;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by abdullahaaf on 11/28/16.
 */

public class BlimbingKecActivity extends AppCompatActivity {

    private ListView lvItemA;
    private String[] kelurahan = new String[]{"Kelurahan Ksatrian","Kelurahan Polehan","Kelurahan Purwantoro",
            "Kelurahan Bunulrejo","Kelurahan Pandanwangi","Kelurahan Blimbing","Kelurahan Pandanwangi","Kelurahan Arjosari",
            "Kelurahan BaleArjosari","Kelurahan Jodipan","Kelurahan polowinen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kec_blimbing);

        getSupportActionBar().setTitle("Kecamatan Blimbing"); //tampil title



        lvItemA = (ListView) findViewById(R.id.list_blimbing);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BlimbingKecActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,kelurahan);

        lvItemA.setAdapter(adapter);
        lvItemA.setSelected(true);

        lvItemA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = kelurahan[i];
                final CharSequence[] dialogitem = {"Lihat Jalan"};
                AlertDialog.Builder builder = new AlertDialog.Builder(BlimbingKecActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0 :

                                if (selection == kelurahan[0])
                                {
                                    Intent a = new Intent(getApplicationContext(), MainActivity_1.class);
                                    a.putExtra("Lowokwaru", selection);
                                    startActivity(a);
                                    break;
                                }

                        }
                    }
                });

                builder.create().show();
            }
        });

        ((ArrayAdapter)lvItemA.getAdapter()).notifyDataSetInvalidated();
    }
}
