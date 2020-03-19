package com.example.taskman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ListViewHolder> {
    private ArrayList<Task> listTask;
    private Activity activityContext;

    public ListTaskAdapter(Activity activity) {
        this.activityContext = activity;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_task, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        if (listTask != null) {
            final Task task = listTask.get(position);
            holder.tvName.setText(task.getName());
            holder.tvTimeRemaining.setText(task.calculateTimeRemaining());
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), TaskDetailActivity.class);
                intent.putExtra(TaskDetailActivity.EXTRA_TASK_NAME, task.getName());
                activityContext.startActivityForResult(intent, 1);
            });
        } else {
            holder.tvName.setText("No Task");
        }
    }

    void setTasks(List<Task> tasks) {
        listTask = (ArrayList<Task>) tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (listTask != null) {
            return listTask.size();
        } else {
            return 0;
        }
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTimeRemaining;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvTimeRemaining = itemView.findViewById(R.id.tv_item_time_remaining);
        }
    }
}
