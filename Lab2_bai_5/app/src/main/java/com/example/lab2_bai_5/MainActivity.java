package com.example.lab2_bai_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Dish dish =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp_thumbnail = (Spinner) findViewById(R.id.sp_thumbnail);
        sp_thumbnail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Thumbnail item = Thumbnail.values()[position];
                switch (item) {
                    case ThumbnailL1:
                        Log.v("MyActivity","Selected item :"+item);
                        break;
                    case ThumbnailL2:
                        Log.v("MyActivity","Selected item :"+item);
                        break;
                    case ThumbnailL3:
                        Log.v("MyActivity","Selected item :"+item);
                        break;
                    case ThumbnailL4:
                        Log.v("MyActivity","Selected item :"+item);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });
        ThumbnailAdapter<Thumbnail> customAdapter=new ThumbnailAdapter<Thumbnail>(this,R.layout.item_thumbnail,Thumbnail.values());
        sp_thumbnail.setAdapter(customAdapter);

        ArrayList<Dish> arrDish=new ArrayList<Dish>();
        DishAdapter adapter= new DishAdapter(this, R.layout.item_dish, arrDish);

        EditText et_name = (EditText) findViewById(R.id.et_name);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        Button btnNhap = (Button) findViewById(R.id.btn_nhap);

        GridView gvFood = (GridView) findViewById(R.id.gridView);
        gvFood.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String text = sp_thumbnail.getSelectedItem().toString();
                Integer img = Thumbnail.valueOf(text).getImg();
                String ten=et_name.getText().toString().trim();
                //Tạo một dish
                dish = new Dish();
                dish.setName(ten);
                // chưa set ảnh được
                dish.setImg(img);
                dish.setPromotion(checkBox.isChecked());
                //Đưa vào danh sách
                arrDish.add(dish);
                //gọi hàm cập nhật giao diện
                adapter.notifyDataSetChanged();
                //Sau khi update thì xóa trắng dữ liệu và cho focus
                et_name.setText("");
                checkBox.setChecked(false);
                et_name.requestFocus();
                sp_thumbnail.setSelection(0);

                Toast.makeText(getApplicationContext(),"Added successfully!", Toast.LENGTH_LONG).show();
            }

        });
    }
}