package com.example.lab2_bai_5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThumbnailAdapter<T> extends ArrayAdapter {
    private Activity context;
    public ThumbnailAdapter(Activity context, int layoutID, Thumbnail[] objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, null, false);
        }

        TextView tvThumbnail = (TextView) convertView.findViewById(R.id.tv_thumbnail);
        ImageView imgThumbnail = (ImageView) convertView.findViewById(R.id.img_thumbnail);

        Thumbnail item = Thumbnail.values()[position];
        if (item.getName()!=null) {
            tvThumbnail.setText(item.getName());
        } else {
            tvThumbnail.setText("");
        }

        if(item.getImg() != 0) {
            imgThumbnail.setImageResource(item.getImg());
        }
        else {
            imgThumbnail.setImageResource(0);
        }

        return convertView;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail, null, false);
        }
        TextView tvThumbnail = (TextView) convertView.findViewById(R.id.tv_thumbnail);
        ImageView imgThumbnail = (ImageView) convertView.findViewById(R.id.img_thumbnail);

        Thumbnail item = Thumbnail.values()[position];
        if (item.getName()!=null) {
            tvThumbnail.setText(item.getName());
        }
        else {
            tvThumbnail.setText("");
        }
        if (item.getImg()!=0) {
            imgThumbnail.setImageResource(item.getImg());
        }
        else {
            imgThumbnail.setImageResource(0);
        }
        imgThumbnail.setVisibility(View.INVISIBLE);
        return convertView;

    }
}
