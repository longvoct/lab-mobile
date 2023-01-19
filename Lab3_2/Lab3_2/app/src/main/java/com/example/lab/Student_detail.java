package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Student_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_detail);
        Intent intent = getIntent();
        String id = intent.getExtras().getString("studentID");
//        Log.v("id", id);
        DatabaseHandler2 db = new DatabaseHandler2(this);
        Student student = db.getStudent(Integer.parseInt(id));
// textview
        TextView tv_id = (TextView) findViewById(R.id.item_tv_id);
        TextView tv_name = (TextView) findViewById(R.id.item_tv_name);
        TextView tv_addr = (TextView) findViewById(R.id.item_tv_addr);
        TextView tv_phone = (TextView) findViewById(R.id.item_tv_phone);

//        edit text
        EditText et_name = (EditText) findViewById(R.id.item_et_name);
        TextView et_addr = (TextView) findViewById(R.id.item_et_addr);
        TextView et_phone = (TextView) findViewById(R.id.item_et_phone);

// render data
        tv_id.setText(String.valueOf(student.getId()));
        tv_name.setText(student.getName());
        tv_addr.setText(student.getAddress());
        tv_phone.setText(student.getPhoneNumber());

//
        Button btnUpdate = (Button) findViewById(R.id.btn_edit);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String ten=et_name.getText()+"";
                String diachi=et_addr.getText()+"";
                String sdt=et_phone.getText()+"";


                Student temp = new Student(student.getId(), ten, diachi, sdt);
                //thêm vào db
                db.updateStudent(temp);
                Toast.makeText(Student_detail.this,"Update successfully!",Toast.LENGTH_LONG).show();
                //Sau khi update thì xóa trắng dữ liệu và update lai
                tv_id.setText(String.valueOf(student.getId()));
                tv_name.setText(ten);
                tv_addr.setText(diachi);
                tv_phone.setText(sdt);
                et_name.setText("");
                et_addr.setText("");
                et_phone.setText("");

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }

        });
    }
}