package com.example.abdullahaaf.newtambalban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by abdullahaaf on 11/28/16.
 */

public class ActivityJalanSumbersari extends AppCompatActivity {
    private ListView lvItemA;
    private String[] kelurahan = new String[]{"Jl.Bendungan Sigura-gura","Jl.Bendungan Sutami",
    "Jl.Gajayana","Jl.Veteran"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jalan_sumbersari_activity);

        getSupportActionBar().setTitle("Kelurahan Sumbersari"); //tampil title



        lvItemA = (ListView) findViewById(R.id.list_jalan_sumbersari);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityJalanSumbersari.this, android.R.layout.simple_list_item_1, android.R.id.text1,kelurahan);

        lvItemA.setAdapter(adapter);
        lvItemA.setSelected(true);
//        lvItemA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                final String selection1 = kelurahan[arg2];
////                final String selection2 = kelurahan[1];
//                final CharSequence[] dialogitem = {"Lihat Kelurahan"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(kelurahan.this);
//                builder.setTitle("Pilihan");
//                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case 0 :
//                                Intent ii = new Intent(getApplicationContext(), MainActivity_1.class);
//                                ii.putExtra("nama", selection1);
//                                startActivity(ii);
//                                break;
//                        }
//                    }
//                });
//
//                builder.create().show();
//            }
//        });

        ((ArrayAdapter)lvItemA.getAdapter()).notifyDataSetInvalidated();

//        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity1.this, "Memilih : "+kelurahan1[position], Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
