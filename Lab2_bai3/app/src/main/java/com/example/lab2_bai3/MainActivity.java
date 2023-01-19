package com.example.lab2_bai3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends Activity {
    Employee employee=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etId = (EditText) findViewById(R.id.et_manv);
        EditText etName = (EditText) findViewById(R.id.et_name);
        Button btnSubmit = (Button) findViewById(R.id.btn_nhap);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        ListView lvNhanvien = (ListView) findViewById(R.id.lv_person);
        ArrayList<Employee> arrNV = new ArrayList<Employee>();
        //đưa Data Source là các employee vào Adapter
        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrNV);
        //đưa adapter vào ListView
        lvNhanvien.setAdapter(adapter);



        btnSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                //Lấy ra đúng id của Radio Button được checked
                int radId = radioGroup.getCheckedRadioButtonId();
                String id = etId.getText() + "";
                String name = etName.getText() + "";
                if (radId == R.id.radChinhthuc) {
                    //tạo instance là FullTime
                    employee = new EmployeeFullTime();
                } else {
                    //Tạo instance là Partime
                    employee = new EmployeePartTime();
                }
                employee.setId(id);
                employee.setName(name);
                //Đưa employee vào ArrayList
                arrNV.add(employee);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
                etId.setText("");
                etName.setText("");
                etId.requestFocus();
            }
        });
    }
}