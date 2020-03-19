package com.example.taskman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTasks;
    private ArrayList<Task> list = new ArrayList<>();
    private TaskViewModel mTaskViewModel;

    public static final int CREATE_NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTasks = findViewById(R.id.rv_tasks);
        rvTasks.setHasFixedSize(true);

        list.addAll(TasksData.getListData());
        showRecyclerList();
        mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
    }

    private void showRecyclerList() {
        ListTaskAdapter listTaskAdapter = new ListTaskAdapter(list, this);
        rvTasks.setAdapter(listTaskAdapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void createNewTask(View view) {
        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        this.startActivity(intent);
    }
}
