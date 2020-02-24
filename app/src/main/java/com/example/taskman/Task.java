package com.example.taskman;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task {
    private String name;
    private LocalDateTime deadline;
    private String status;
    private boolean type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long getHours() {
        LocalDateTime fromDateTime = this.deadline;
        LocalDateTime toDateTime = LocalDateTime.now();
        LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );
        long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
        tempDateTime = tempDateTime.plusYears( years );
        long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
        tempDateTime = tempDateTime.plusMonths( months );
        long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
        tempDateTime = tempDateTime.plusDays( days );
        long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
        return hours;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long getMinutes() {
        LocalDateTime fromDateTime = this.deadline;
        LocalDateTime toDateTime = LocalDateTime.now();
        LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );
        long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
        tempDateTime = tempDateTime.plusYears( years );
        long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
        tempDateTime = tempDateTime.plusMonths( months );
        long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
        tempDateTime = tempDateTime.plusDays( days );
        long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
        tempDateTime = tempDateTime.plusHours( hours );
        long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES );
        return minutes;
    }
}