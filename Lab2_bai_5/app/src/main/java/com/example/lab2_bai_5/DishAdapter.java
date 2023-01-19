package com.example.lab2_bai_5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    public DishAdapter(Activity context, int layoutID, List<Dish> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, null, false);
        }
        // Get item
        Dish dish = getItem(position);
        // Get view
        ImageView imgDish = (ImageView) convertView.findViewById(R.id.img_dish);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
//       --- hỏi cô
        tvName.setSelected(true);
        ImageView isPromotion = (ImageView) convertView.findViewById(R.id.img_promotion);
//        ConstraintLayout llParent = (ConstraintLayout) convertView.findViewById(R.id.item_dish_ll_parent);

        if(dish.getImg()!= 0) {
            imgDish.setImageResource(dish.getImg());
        } else {
            imgDish.setImageResource(R.drawable.fourth_thumbnail);
        }
        if (dish.getName()!=null) {
            tvName.setText(dish.getName());
        }
        else tvName.setText("");
//
        if (dish.isPromotion()) {
            isPromotion.setVisibility(View.VISIBLE);
        }
        else {
            isPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
