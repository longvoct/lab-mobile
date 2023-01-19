package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Lab3_bai2 extends AppCompatActivity {
    Student student=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai2);

        DatabaseHandler2 db = new DatabaseHandler2(this);
        List<Student> students = db.getAllStudents();


        RecyclerView recyclerView = findViewById(R.id.lv_student);
        ArrayList<Student> arrStudent = (ArrayList<Student>) students;

        StudentAdapter adapter = new StudentAdapter(this, arrStudent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_addr = (EditText) findViewById(R.id.et_addr);
        EditText et_phone = (EditText) findViewById(R.id.et_phone);
        Button btnNhap = (Button) findViewById(R.id.btn_add);


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String ten=et_name.getText()+"";
                String diachi=et_addr.getText()+"";
                String sdt=et_phone.getText()+"";

                student = new Student(ten, diachi, sdt);
                //thêm vào db
                db.addStudent(new Student(ten, diachi, sdt));
//                students = db.getAllStudents();
                //Đưa vào danh sách
                arrStudent.add(student);
                //gọi hàm cập nhật giao diện
                adapter.notifyDataSetChanged();

                //Sau khi update thì xóa trắng dữ liệu và cho editma focus
                et_name.setText("");
                et_addr.setText("");
                et_phone.setText("");
            }
        });

        // --->> xử lý sự kiện Long click -- xóa

        ItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                // do it
                // xóa trong db
                db.deleteStudent(arrStudent.get(position));
                // xóa phần tử thứ arg2
                arrStudent.remove(position);
//
                adapter.notifyDataSetChanged();

                return false;
            }
        });

        // --->> xử lý sự kiện click -- xem chi tiet

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
                Intent i = new Intent(Lab3_bai2.this, Student_detail.class);
                List<Student> students2 = db.getAllStudents();
                String id = String.valueOf(students2.get(position).getId());
                i.putExtra("studentID", id);
                startActivity(i);
            }
        });

    }

    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
        DatabaseHandler2 db = new DatabaseHandler2(this);
        List<Student> students = db.getAllStudents();


        RecyclerView recyclerView = findViewById(R.id.lv_student);
        ArrayList<Student> arrStudent = (ArrayList<Student>) students;

        StudentAdapter adapter = new StudentAdapter(this, arrStudent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}