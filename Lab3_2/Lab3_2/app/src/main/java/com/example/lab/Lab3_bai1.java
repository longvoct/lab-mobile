package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lab3_bai1 extends AppCompatActivity {

    private Cursor cursor;
    private List<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai1);

        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();


//        ---> basic
        ListView lvContact = (ListView) findViewById(R.id.lv_contact);

        ArrayList listNameContacts = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNameContacts);
        lvContact.setAdapter(adapter);

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+", Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            listNameContacts.add(log);
            //Cập nhật dữ liệu mới lên giao diên
            adapter.notifyDataSetChanged();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }




        // --->> xử lý sự kiện Long click
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                listNameContacts.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
//                xóa trong db
                db.deleteContact(contacts.get(arg2));
                return false;
            }
        });




    }
}