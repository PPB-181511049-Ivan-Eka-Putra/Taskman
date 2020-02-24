package com.example.taskman;

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

public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ListViewHolder> {
    private ArrayList<Task> listTask;

    public ListTaskAdapter(ArrayList<Task> list) {
        this.listTask = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_task, parent, false);
        return new ListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Task task = listTask.get(position);
        holder.tvName.setText(task.getName());
        holder.tvTimeRemaining.setText(((int) task.getHours()) + " hr " + ((int) task.getMinutes()) + " min");
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
