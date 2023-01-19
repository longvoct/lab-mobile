package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lvPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Array initialization
        final String [] arr={"Teo","Ty","Bin","Bo"};
        //2. GetAttribute by ID
        ListView lvPerson =(ListView) findViewById(R.id.lv_person);
        //3. Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Put Data source into ListView
        lvPerson.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.tvSelection);
        //5. Set events for Listview
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data  Source (arr)
                        txt.setText("position :"+ arg2 +" ; value ="+arr[arg2]);
                    }
                });
    }
}