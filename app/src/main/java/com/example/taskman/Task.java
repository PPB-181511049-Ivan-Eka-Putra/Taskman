package com.example.taskman;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private  int mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @NonNull
    @ColumnInfo(name = "deadline")
    private Date mDeadline;

    @NonNull
    @ColumnInfo(name = "status")
    private String mStatus;

    @NonNull
    @ColumnInfo(name = "type")
    private boolean mType;

    public Task(@NonNull int id, @NonNull String name, @NonNull Date deadine, @NonNull String status, @NonNull boolean type) {
        this.mId = id;
        this.mName = name;
        this.mDeadline = deadine;
        this.mStatus = status;
        this.mType = type;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Date getDeadline() {
        return mDeadline;
    }

    public String getStatus() {
        return mStatus;
    }
}