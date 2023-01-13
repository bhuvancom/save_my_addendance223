package com.example.save_my_addendance223;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author  : Mohit
 **/

public class StudentListAdapter223 extends ListAdapter<Student, StudentListAdapter223.StViewHolder> {

    protected StudentListAdapter223(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class StViewHolder extends RecyclerView.ViewHolder {
        TextView name, regNo, attn, gender;

        private TextView getView(View v, @IdRes int id) {
            return v.findViewById(id);
        }

        public StViewHolder(@NonNull View itemView) {
            super(itemView);
            name = getView(itemView, R.id.name);
            regNo = getView(itemView, R.id.reg_no);
            attn = getView(itemView, R.id.attn_perc);
            gender = getView(itemView, R.id.gender);
        }

        public void bind(Student student) {
            name.setText("Name - " + student.name);
            regNo.setText("Roll no - " + student.rollNumber);
            attn.setText("Attendance - " + student.attendancePercent + "%");
            gender.setText("Gender - " + student.gender);
        }
    }
}
