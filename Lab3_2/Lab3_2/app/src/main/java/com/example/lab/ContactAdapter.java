package com.example.lab;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private  List<Contact> objects;
    private Activity context;
    public class ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvPhone;
        LinearLayout llParent;
    }
    public ContactAdapter(Activity context, int layoutID, List<Contact> objects) {
        super(context, layoutID, objects);
        this.context = context;
        this.objects = objects;
        Log.e("data", String.valueOf(this.objects.size()));
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, null);
            holder.tvName = (TextView) convertView.findViewById(R.id.item_contact_name);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.item_contact_phone);
            holder.llParent = (LinearLayout) convertView.findViewById(R.id.item_contact_ll_parent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
/*        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact, null, false);
            TextView tv = (TextView) convertView.findViewById(R.id.item_contact_id);
        }*/
        // Get item
      //  LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_contact_ll_parent);
        Contact contact = objects.get(position);
        // Get view

       /* TextView tvName = (TextView) convertView.findViewById(R.id.item_contact_name);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.item_contact_phone);
        LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_contact_ll_parent);*/
        // Set
        if (holder.tvName != null) {
            if (contact.getId()!=0 ) {
                holder.tvName.setText("1234");
            }
            else holder.tvName.setText("abc");
               }
         /*
        if (tvName != null) {
            if (contact.getName()!=null) {
                tvName.setText(contact.getName());
            }
            else tvName.setText("");
        }
        if (tvPhone != null) {
            if (contact.getPhoneNumber() != null) {
                tvPhone.setText(contact.getPhoneNumber());
            } else tvPhone.setText("");
        }*/
        // Show different color backgrounds for 2 continuous employees
/*        if (position%2==0) {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else {
            holder.llParent.setBackgroundResource(R.color.color9);
        }*/
        return convertView;
    }
}