package com.example.taskman;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    public Task(@NonNull String name, @NonNull Date deadline) {
        this.mName = name;
        this.mDeadline = deadline;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setDeadline(Date deadline) {
        this.mDeadline = deadline;
    }

    public Date getDeadline() {
        return mDeadline;
    }

    public String calculateTimeRemaining() {
        String timeRemaining;

        long different = mDeadline.getTime() - Calendar.getInstance().getTimeInMillis();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        if (elapsedDays != 0) {
            timeRemaining = elapsedDays + " days " + elapsedHours + " hours " + elapsedMinutes + " minutes " + elapsedSeconds + " seconds";
        } else if (elapsedHours != 0) {
            timeRemaining = elapsedHours + " hours " + elapsedMinutes + " minutes " + elapsedSeconds + " seconds";
        } else if (elapsedMinutes != 0) {
            timeRemaining = elapsedMinutes + " minutes " + elapsedSeconds + " seconds";
        } else {
            timeRemaining = elapsedSeconds + " seconds";
        }
        return timeRemaining;
    }
}