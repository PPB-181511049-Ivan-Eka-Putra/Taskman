package com.example.taskman;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Task {
    private String name;
    private Date deadline;
    private String status;
    private boolean type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String CalculateTimeRemaining() {
        String timeRemaining;

        long different = deadline.getTime() - Calendar.getInstance().getTimeInMillis();

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