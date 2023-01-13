package com.example.save_my_addendance223;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MyAppDB myAppDB;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.attandance_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int show = -2;
        if (item.getItemId() == R.id.menu_all) {
            show = 0;
        } else if (item.getItemId() == R.id.menu_65) {
            show = 65;
        } else if (item.getItemId() == R.id.menu_25) {
            show = 25;
        } else if (item.getItemId() == R.id.menu_male) {
            show = -1;
        }
        if (show >= -1) {
            Intent intent = new Intent(MainActivity.this, StudentList223.class);
            intent.putExtra("show", show);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    String getValue223(@IdRes int id) {
        TextInputLayout layout = findViewById(id);
        return layout.getEditText().getText().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDB = new MyAppDB(this);
        Button btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitStudent();
            }
        });
    }

    private int attn(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void submitStudent() {
        String regNo = getValue223(R.id.reg_no);
        String name = getValue223(R.id.name);
        int att = attn(getValue223(R.id.attn_perc));
        RadioGroup gender = findViewById(R.id.rg_atn);
        int rb = gender.getCheckedRadioButtonId();
        RadioButton rbt = findViewById(rb);
        String gen = rbt.getText().toString();
        Student s = new Student(name, regNo, att, gen);
        myAppDB.addStudent(s);

        Toast.makeText(this, "Added success", Toast.LENGTH_SHORT).show();
    }

}