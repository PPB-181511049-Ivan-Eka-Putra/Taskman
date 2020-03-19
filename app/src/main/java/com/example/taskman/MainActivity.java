package com.example.taskman;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        ListTaskAdapter listTaskAdapter = new ListTaskAdapter(this);
        rvTasks.setAdapter(listTaskAdapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        mTaskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable final List<Task> tasks) {

                // Update the cached copy of the tasks in the adapter.
                listTaskAdapter.setTasks(tasks);
            }
        });
    }

    public void createNewTask(View view) {
        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        startActivityForResult(intent, CREATE_NEW_TASK_ACTIVITY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Task task = new Task(data.getStringExtra(CreateNewTaskActivity.EXTRA_TASK_NAME), TasksData.getDateFromString(data.getStringExtra(CreateNewTaskActivity.EXTRA_TASK_DEADLINE)));
            mTaskViewModel.insert(task);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
