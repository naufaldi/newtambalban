package com.example.abdullahaaf.newtambalban;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by abdullahaaf on 11/28/16.
 */

public class LowokwaruActivity extends Activity
{

    private ListView lvItemA;
    private String[] kelurahan = new String[]{
            "Kelurahan Sumbersari","Kelurahan Mojolangu"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

//        getSupportActionBar().setTitle("Kecamatan Lowokwaru"); //tampil title



        lvItemA = (ListView) findViewById(R.id.list_kelurahan);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LowokwaruActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,kelurahan);

        lvItemA.setAdapter(adapter);
        lvItemA.setSelected(true);
        lvItemA.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final String selection = kelurahan[i];
                final CharSequence[] dialogitem = {"lihat list jalan"};
                AlertDialog.Builder builder = new AlertDialog.Builder(LowokwaruActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        switch (i)
                        {
                            case 0 :

                                if (selection == kelurahan[0])
                                {
                                    Intent a = new Intent(getApplicationContext(), ActivityJalanSumbersari.class);
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
