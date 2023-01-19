package com.example.lab2_bai_6;

import android.content.Context;
//import android.support.v7.widget. ;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapterR extends RecyclerView.Adapter<EmployeeAdapterR.ViewHolder> {
    private List<Employee> employees;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    EmployeeAdapterR(Context context, List<Employee> data) {
        this.mInflater = LayoutInflater.from(context);
        this.employees = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvFullName;
        public TextView tvPosition;
        public ImageView ivManager;
        public LinearLayout llParent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById((R.id.item_employee_tv_fullname));
            tvPosition = itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.item_employee_ll_parent);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        Employee employee = (Employee) employees.get(position);

        holder.tvFullName.setText(employee.getName());
        if(employee.isManager()) {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        } else {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
        }
        if (position%2==0) {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }


    @Override
    public int getItemCount() {
        return employees.size();
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}