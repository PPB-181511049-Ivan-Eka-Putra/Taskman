package com.example.taskman;

import android.app.Activity;
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

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ListViewHolder> {
    private ArrayList<Task> listTask;
    private Activity activityContext;

    public ListTaskAdapter(ArrayList<Task> list, Activity activity) {
        this.listTask = list;
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
        final Task task = listTask.get(position);
        holder.tvName.setText(task.getName());
        holder.tvTimeRemaining.setText(task.CalculateTimeRemaining());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TaskDetailActivity.class);
                intent.putExtra(TaskDetailActivity.EXTRA_TASK_NAME, task.getName());
                intent.putExtra(TaskDetailActivity.EXTRA_TASK_STATUS, task.getStatus());
                ((Activity) activityContext).startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTask.size();
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
