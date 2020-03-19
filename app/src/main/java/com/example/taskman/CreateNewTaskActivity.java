package com.example.taskman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_TASK_NAME = "com.example.android.tasklistsql.TASK_NAME";
    public static final String EXTRA_TASK_DEADLINE = "com.example.android.tasklistsql.TASK_DEADLINE";

    EditText etTaskName;
    EditText etTaskDeadline;
    Button b;

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);

        etTaskName = findViewById(R.id.et_task_name);
        etTaskDeadline = findViewById(R.id.et_task_deadline);

        b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(etTaskName.getText()) && TextUtils.isEmpty(etTaskDeadline.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String taskName = etTaskName.getText().toString();
                    String taskDeadline = etTaskDeadline.getText().toString();
                    replyIntent.putExtra(EXTRA_TASK_NAME, taskName);
                    replyIntent.putExtra(EXTRA_TASK_DEADLINE, taskDeadline);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

    public void insertTask(View view) {
        // Add a task
        db.open();
        long id = db.insertTask(etTaskName.getText().toString(), etTaskDeadline.getText().toString());
        db.close();
        finish();
    }
}
