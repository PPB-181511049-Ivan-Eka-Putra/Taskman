package com.example.taskman;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TasksData {
    private static String[] taskNames = {
            "Mengimplementasikan aplikasi dengan menerapkan konsep Activity",
            "Memunculkan data pada RecyclerView",
            "Mengerjakan Front-End fitur log in"
    };

    private static LocalDateTime[] taskDeadlines;

    static {
        try {
            taskDeadlines = new LocalDateTime[]{
                    getLocalDateTimeFromString("2020-02-25 15:03"),
                    getLocalDateTimeFromString("25/02/2020"),
                    getLocalDateTimeFromString("24/02/2020")
                };
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String[] taskStatus = {
            "In Progress",
            "In Progress",
            "In Progress"
    };

    private static boolean[] taskTypes = {
            true,
            true,
            true
    };

    public TasksData() throws ParseException {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getLocalDateTimeFromString(String s) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime result = LocalDateTime.parse(s, formatter);
        return result;
    }

    static ArrayList<Task> getListData() {
        ArrayList<Task> list = new ArrayList<>();
        for (int position = 0; position < taskNames.length; position++) {
            Task task = new Task();
            task.setName(taskNames[position]);
            task.setDeadline(taskDeadlines[position]);
            task.setStatus(taskStatus[position]);
            task.setType(taskTypes[position]);
            list.add(task);
        }
        return list;
    }
}
