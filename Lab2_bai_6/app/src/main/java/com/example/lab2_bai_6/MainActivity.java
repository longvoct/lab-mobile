package com.example.lab2_bai_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.lv_person);
        ArrayList<Employee> arrEmployee = new ArrayList<Employee>();

        EmployeeAdapterR adapter = new EmployeeAdapterR(this, arrEmployee);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        EditText et_id = (EditText) findViewById(R.id.et_manv);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        Button btnNhap = (Button) findViewById(R.id.btn_nhap);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String ma = et_id.getText() + "";
                String ten = et_name.getText() + "";
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
                checkBox.setChecked(false);
                et_id.requestFocus();
            }
        });
    }
}