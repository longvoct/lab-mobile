package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Lab2_bai4 extends AppCompatActivity {

    Employee employee=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_bai4);
        ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
        EmployeeAdapter adapter= new EmployeeAdapter(this, R.layout.item_employee, arrEmployee);
        EditText et_id = (EditText) findViewById(R.id.et_manv);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        Button btnNhap = (Button) findViewById(R.id.btn_nhap);
        ListView lvNhanvien = (ListView) findViewById(R.id.lv_person);
        lvNhanvien.setAdapter(adapter);//gán Adapter vào Lisview;
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String ma=et_id.getText()+"";
                String ten=et_name.getText()+"";
                //Tạo một employee, dùng tạm EmployeeFullTime tại vì employee đang là lớp abstract
                employee = new EmployeeFullTime();
                employee.setId(ma);
                employee.setName(ten);
                employee.setManager(checkBox.isChecked());
                //Đưa vào danh sách
                arrEmployee.add(employee);
                //gọi hàm cập nhật giao diện
                adapter.notifyDataSetChanged();
                //Sau khi update thì xóa trắng dữ liệu và cho editma focus
                et_id.setText("");
                et_name.setText("");
                et_id.requestFocus();
                checkBox.setChecked(false);
            }
        });
    }
}