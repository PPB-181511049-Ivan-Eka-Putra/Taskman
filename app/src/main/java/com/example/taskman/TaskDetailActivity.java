package com.example.taskman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TASK_NAME = "extra_task_name";
    public static final String EXTRA_TASK_STATUS = "extra_task_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView tvTaskName = findViewById(R.id.tv_task_name);
        String taskName = getIntent().getStringExtra(EXTRA_TASK_NAME);
        tvTaskName.setText(taskName);

        Button bStatus = findViewById(R.id.b_status);
        String taskStatus = getIntent().getStringExtra(EXTRA_TASK_STATUS);
        if (taskStatus == "To Do") {
            bStatus.setText("Do it");
        } else {
            bStatus.setText("Finish");
        }
    }

    public void onClick(View view) {
        Button bStatus = findViewById(R.id.b_status);
        String taskName = getIntent().getStringExtra(EXTRA_TASK_NAME);

        Intent i = new Intent();
        if (bStatus.getText() == "Do it") {
            i.setData(Uri.parse(taskName + " in progress"));
        } else {
            i.setData(Uri.parse(taskName + " completed"));
        }
        setResult(RESULT_OK, i);
        finish();
    }
}
