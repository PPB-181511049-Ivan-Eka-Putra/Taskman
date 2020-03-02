package com.example.taskman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTasks;
    private ArrayList<Task> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTasks = findViewById(R.id.rv_tasks);
        rvTasks.setHasFixedSize(true);

        list.addAll(TasksData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        ListTaskAdapter listTaskAdapter = new ListTaskAdapter(list);
        rvTasks.setAdapter(listTaskAdapter);
    }
}
