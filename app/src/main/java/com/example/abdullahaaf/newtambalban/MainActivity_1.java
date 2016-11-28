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

public class MainActivity_1 extends AppCompatActivity {

    private ListView lvItemA;
    private String[] kelurahan = new String[]{
            "Kelurahan Sumbersari","Kelurahan Mojolangu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        getSupportActionBar().setTitle("Kecamatan Lowokwaru"); //tampil title



        lvItemA = (ListView) findViewById(R.id.list_kelurahan);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity_1.this, android.R.layout.simple_list_item_1, android.R.id.text1,kelurahan);

        lvItemA.setAdapter(adapter);
        lvItemA.setSelected(true);
        lvItemA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = kelurahan[i];
                final CharSequence[] dialogitem = {"Lihat Jalan"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_1.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0 :

                                if (selection == kelurahan[0])
                                {
                                    Intent a = new Intent(getApplicationContext(), ActivityJalanSumbersari.class);
                                    a.putExtra("Lowokwaru", selection);
                                    startActivity(a);
                                    break;
                                }
//                                if (selection == kelurahan[1])
//                                {
//                                    Intent b = new Intent(getApplicationContext(), BlimbingKecActivity.class);
//                                    b.putExtra("Blimbing", selection);
//                                    startActivity(b);
//                                    break;
//                                }

                        }
                    }
                });

                builder.create().show();
            }
        });


        ((ArrayAdapter)lvItemA.getAdapter()).notifyDataSetInvalidated();

//        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity1.this, "Memilih : "+kelurahan1[position], Toast.LENGTH_LONG).show();
//            }
//        });
    }

}
