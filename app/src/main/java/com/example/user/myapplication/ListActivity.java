package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 2017-05-29.
 */

public class ListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        final String[] groups = {"그룹 1","그룹 2","그룹 3"};

        ListView listview = (ListView)findViewById(R.id.listview1);
        ArrayAdapter listadapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,groups);
        Button addbtn = (Button)findViewById(R.id.addbtn);

        listview.setAdapter(listadapter);

        addbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });

    }
}
