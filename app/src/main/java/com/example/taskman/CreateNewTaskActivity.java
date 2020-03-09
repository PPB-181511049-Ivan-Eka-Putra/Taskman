package com.example.taskman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNewTaskActivity extends AppCompatActivity {

    EditText etTaskName;
    EditText etTaskDeadline;

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);

        etTaskName = findViewById(R.id.et_task_name);
        etTaskDeadline = findViewById(R.id.et_task_deadline);

        db = new DBAdapter(this);
    }

    public void insertTask(View view) {
        // Add a task
        db.open();
        long id = db.insertTask(etTaskName.getText().toString(), etTaskDeadline.getText().toString());
        db.close();
        finish();
    }
}
