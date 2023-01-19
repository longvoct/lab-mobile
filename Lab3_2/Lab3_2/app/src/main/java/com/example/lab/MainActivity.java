package com.example.lab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_bai1);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView tvSelection = (TextView) findViewById(R.id.tv_selection);
        final String arr[] = {"Teo", "Ty", "Son", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //                arg0.setBackgroundColor(getColor(R.color. white));
                //                arg1.setBackgroundColor(getColor(R.color. color6));
                //đối số arg2 là vị trí phần tử trong Data Source (arr)
                tvSelection.setText("position :" + arg2 + " ; value =" + arr[arg2]);
            }
        });
    }
}