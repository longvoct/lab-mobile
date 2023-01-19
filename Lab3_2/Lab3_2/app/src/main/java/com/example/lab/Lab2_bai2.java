package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Lab2_bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_bai2);
        Button btnSubmit = (Button) findViewById(R.id.btn_nhap);
        EditText etName = (EditText) findViewById(R.id.et_name);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView tvSelection = (TextView) findViewById(R.id.tv_selection);
        //1. Tạo ArrayList object
        ArrayList names = new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        //3. gán Adapter vào ListView
        lvPerson.setAdapter(adapter);
        //4. Xử lý sự kiện nhấn nút Nhập
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Log.v("EditText", etName.getText().toString());
                //Thêm dữ liệu mới vào arraylist
                names.add(etName.getText().toString());
                //Cập nhật dữ liệu mới lên giao diên
                adapter.notifyDataSetChanged();
                etName.setText("");
            }
        });
        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                tvSelection.setText("position : "+ arg2+ "; value ="+ names.get(arg2));
            }
        });
        //6. xử lý sự kiện Long click
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                names.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}