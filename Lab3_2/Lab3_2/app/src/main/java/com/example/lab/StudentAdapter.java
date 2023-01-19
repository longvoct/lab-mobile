package com.example.lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    private List<Student> students;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    StudentAdapter(Context context, List<Student> data) {
        this.mInflater = LayoutInflater.from(context);
        this.students = data;
    }

    public interface OnItemClickListener {
        public void onItemClicked(int position);
    }

    public interface OnItemLongClickListener {
        public boolean onItemLongClicked(int position);
    }



    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public TextView tvId;
        public TextView tvName;
        public TextView tvAddr;

        public LinearLayout llParent;

        public ViewHolder(View itemView) {
            super(itemView);
//            tvId = itemView.findViewById((R.id.item_student_tv_id));
            tvName = itemView.findViewById(R.id.item_student_tv_name);
            tvAddr = itemView.findViewById(R.id.item_student_tv_addr);
            llParent = itemView.findViewById(R.id.item_student_ll_parent);

            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//
//                @Override
//
//                public boolean onLongClick(View view) {
//                    // xoa db
////                    DatabaseHandler2 db = new DatabaseHandler2(this);
////                    db.deleteStudent(students.get(getAdapterPosition()));
//                    // xoas list
//                    students.remove(getAdapterPosition());
//
//                    notifyItemRemoved(getAdapterPosition());
//
//                    return true;
//
//                }
//
//            });
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        // Nạp layout cho View biểu diễn phần tử sinh viên
//        View employeeView =
//                inflater.inflate(R.layout.item_employee, parent, false);
//
//        ViewHolder viewHolder = new ViewHolder(employeeView);
//        return viewHolder;
        View view = mInflater.inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = (Student) students.get(position);

//        holder.tvId.setText(student.getId());
        holder.tvName.setText(student.getName());
        holder.tvAddr.setText(student.getAddress());

//        holder.ivManager.setText(employee.getId());
//        if(employee.isManager()) {
//            holder.ivManager.setVisibility(View.VISIBLE);
//            holder.tvPosition.setVisibility(View.GONE);
//        } else {
//            holder.ivManager.setVisibility(View.GONE);
//            holder.tvPosition.setVisibility(View.VISIBLE);
//        }
        if (position%2==0) {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }

    }


    @Override
    public int getItemCount() {
        return students.size();
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
