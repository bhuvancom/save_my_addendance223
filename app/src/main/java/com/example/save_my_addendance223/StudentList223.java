package com.example.save_my_addendance223;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentList223 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list223);
        TextView textView = findViewById(R.id.tv_menu_top2);
        RecyclerView rv = findViewById(R.id.rv_students);

        DiffUtil.ItemCallback<Student> itemCallback = new DiffUtil.ItemCallback<Student>() {

            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem == newItem;
            }
        };

        int show = getIntent().getIntExtra("show", 0);
        StudentListAdapter223 studentListAdapter223 = new StudentListAdapter223(itemCallback);
        MyAppDB myAppDB = new MyAppDB(this);
        List<Student> student = null;
        String msg = "All Student";
        if (show == 25) {
            msg = "Students with attendance less than 25%";
            student = myAppDB.get25Perc();
        } else if (show == 65) {
            msg = "Students with attendance less than 65%";
            student = myAppDB.get65Student();
        } else if (show == -1) {
            msg = "All male students";
            student = myAppDB.getAllMale();
        } else {
            student = myAppDB.getAllStudent();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textView.setText(msg);
        studentListAdapter223.submitList(student);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(studentListAdapter223);

    }
}